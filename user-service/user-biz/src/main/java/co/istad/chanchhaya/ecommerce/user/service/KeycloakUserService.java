package co.istad.chanchhaya.ecommerce.user.service;

import org.keycloak.representations.idm.UserRepresentation;

public interface KeycloakUserService {

    void createKeycloakUser(UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserByUsername(String username);

    void updateKeycloakUser(String id, UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserById(String id);

    void deleteKeycloakUserById(String id);
}
