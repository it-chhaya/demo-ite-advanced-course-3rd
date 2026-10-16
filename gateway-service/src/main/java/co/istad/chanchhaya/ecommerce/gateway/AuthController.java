package co.istad.chanchhaya.ecommerce.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/secured")
    public Map<String, String> getSecuredAuth() {
        return Map.of("message", "This is secured auth");
    }

}
