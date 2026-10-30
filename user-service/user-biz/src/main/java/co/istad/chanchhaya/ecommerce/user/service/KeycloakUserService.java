package co.istad.chanchhaya.ecommerce.user.service;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface KeycloakUserService {

    void createKeycloakUser(UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserByUsername(String username);

    void updateKeycloakUser(String id, UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserById(String id);

    Slice<UserRepresentation> getKeycloakUsersByRoleName(String roleName, Pageable pageable);

    Slice<UserRepresentation> getKeycloakUsers(Pageable pageable);

    void deleteKeycloakUserById(String id);
}
