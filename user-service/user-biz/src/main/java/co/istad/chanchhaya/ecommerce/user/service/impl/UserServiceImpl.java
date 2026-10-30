package co.istad.chanchhaya.ecommerce.user.service.impl;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;
import co.istad.chanchhaya.ecommerce.user.dto.UserUpdateRequest;
import co.istad.chanchhaya.ecommerce.user.entity.UserEntity;
import co.istad.chanchhaya.ecommerce.user.exception.PasswordMismatchException;
import co.istad.chanchhaya.ecommerce.user.exception.UserNotFoundException;
import co.istad.chanchhaya.ecommerce.user.exception.UsernameConflictException;
import co.istad.chanchhaya.ecommerce.user.mapper.UserMapper;
import co.istad.chanchhaya.ecommerce.user.repository.UserRepository;
import co.istad.chanchhaya.ecommerce.user.service.KeycloakRoleService;
import co.istad.chanchhaya.ecommerce.user.service.KeycloakUserService;
import co.istad.chanchhaya.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final KeycloakUserService keycloakUserService;
    private final KeycloakRoleService keycloakRoleService;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = userMapper.toEntity(userCreateRequest);

        // Validate username
        if (userRepository.existsByUsername(userCreateRequest.username())) {
            throw new UsernameConflictException(HttpStatus.CONFLICT,
                    "Username already exists");
        }

        // Validate password
        if (!userCreateRequest.password().equals(userCreateRequest.confirmedPassword())) {
            throw new PasswordMismatchException(HttpStatus.BAD_REQUEST,
                    "Password does not match");
        }

        // Save user into Keycloak
        // After saved user, save user into DB
        UserRepresentation userRepresentation = userMapper.toRepresentation(userCreateRequest);
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userCreateRequest.password());

        userRepresentation.setCredentials(List.of(credentialRepresentation));

        keycloakUserService.createKeycloakUser(userRepresentation);
        UserRepresentation createdUser = keycloakUserService.getKeycloakUserByUsername(
                userEntity.getUsername()
        );
        log.info("User created: {}", createdUser);
        keycloakRoleService.assignRoles(createdUser.getId(), userCreateRequest.roleName());

        // Saving user into database
        userEntity.setId(createdUser.getId());
        userRepository.save(userEntity);

        return userMapper.toResponse(userEntity, createdUser);
    }


    @Override
    public UserResponse update(String id, UserUpdateRequest userUpdateRequest) {

        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));

        userMapper.toEntity(userUpdateRequest, userEntity);
        userRepository.save(userEntity);

        UserRepresentation userRepresentation = keycloakUserService
                .getKeycloakUserByUsername(userEntity.getUsername());

        // Attempt to Keycloak data
        if (!(userUpdateRequest.familyName() == null && userUpdateRequest.givenName() == null)) {
            if (userUpdateRequest.familyName() != null) {
                userRepresentation.setFirstName(userUpdateRequest.familyName());
            }

            if (userUpdateRequest.givenName() != null) {
                userRepresentation.setLastName(userUpdateRequest.givenName());
            }

            keycloakUserService.updateKeycloakUser(id, userRepresentation);
        }

        return userMapper.toResponse(userEntity, userRepresentation);
    }


    @Override
    public UserResponse getById(String id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
        UserRepresentation userRepresentation = keycloakUserService.getKeycloakUserById(id);

        return userMapper.toResponse(
                userEntity,
                userRepresentation
        );
    }


    @Override
    public UserResponse getByUsername(String username) {
        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
        UserRepresentation userRepresentation = keycloakUserService.getKeycloakUserByUsername(username);

        return userMapper.toResponse(
                userEntity,
                userRepresentation
        );
    }


    @Override
    public void deleteById(String id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
        userRepository.delete(userEntity);
        keycloakUserService.deleteKeycloakUserById(id);
    }
}
