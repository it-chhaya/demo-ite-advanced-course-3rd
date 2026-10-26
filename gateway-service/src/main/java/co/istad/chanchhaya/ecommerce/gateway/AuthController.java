package co.istad.chanchhaya.ecommerce.gateway;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/me")
    public Map<String, Object> getSecuredAuth(@AuthenticationPrincipal OAuth2User oAuth2User) {
        if (oAuth2User == null) {
            return Map.of(
                    "authenticated", false
            );
        }
        return Map.of(
                "authenticated", true,
                "userId", oAuth2User.getName(),
                "permission", oAuth2User.getAuthorities()
        );
    }

}
