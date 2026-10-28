package co.istad.chanchhaya.ecommerce.user.service.impl;

import co.istad.chanchhaya.ecommerce.user.config.KeycloakAdminClientConfig;
import co.istad.chanchhaya.ecommerce.user.service.KeycloakRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakRoleServiceImpl implements KeycloakRoleService {

    private final Keycloak keycloak;

    @Override
    public void assignRoles(String userId, String roleNameWithDelimiter) {

        String[] roleNameList = roleNameWithDelimiter.split(",");
        List<RoleRepresentation> roleRepresentationList = Arrays.stream(roleNameList)
                .map(this::getKeycloakRoleByName)
                .toList();

        keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .get(userId)
                .roles()
                .realmLevel()
                .add(roleRepresentationList);
    }


    private RoleRepresentation getKeycloakRoleByName(String roleName) {
        return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .roles()
                .get(roleName)
                .toRepresentation();
    }

}
