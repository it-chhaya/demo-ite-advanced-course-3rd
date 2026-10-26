package co.istad.chanchhaya.ecommerce.user.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminClientConfig {

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8888")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("ecommerce-admin-client")
                .clientSecret("ToetUAbcfwlFTvynB3jLyVhtNYml2KOQqWtL17LaBAcsybTgxS58hm75sk9WQGCOMPN0S8AWUtQ4YSjlFfadH9")
                .realm("ecommerce")
                .build();
    }

}
