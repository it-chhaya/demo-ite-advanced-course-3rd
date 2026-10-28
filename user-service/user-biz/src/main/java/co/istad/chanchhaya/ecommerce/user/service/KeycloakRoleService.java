package co.istad.chanchhaya.ecommerce.user.service;

public interface KeycloakRoleService {

    void assignRoles(String userId, String roleNameWithDelimiter);

}
