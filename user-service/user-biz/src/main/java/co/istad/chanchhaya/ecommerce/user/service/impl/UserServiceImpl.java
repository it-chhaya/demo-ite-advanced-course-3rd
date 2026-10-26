package co.istad.chanchhaya.ecommerce.user.service.impl;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;
import co.istad.chanchhaya.ecommerce.user.entity.UserEntity;
import co.istad.chanchhaya.ecommerce.user.exception.PasswordMismatchException;
import co.istad.chanchhaya.ecommerce.user.exception.UsernameConflictException;
import co.istad.chanchhaya.ecommerce.user.mapper.UserMapper;
import co.istad.chanchhaya.ecommerce.user.repository.UserRepository;
import co.istad.chanchhaya.ecommerce.user.service.UserService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
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

    private final Keycloak keycloak;

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

        try (Response response = keycloak.realm("ecommerce")
                .users()
                .create(userRepresentation)) {
            log.info("Keycloak response: {}", response.getStatus());
            if (response.getStatus() == HttpStatus.CREATED.value()) {
                log.info("Created user");
            } else if (response.getStatus() == HttpStatus.CONFLICT.value()) {
                log.info("Keycloak user data conflict");
            } else {
                log.info("Cannot create user");
            }
        }



        return null;
    }

}
