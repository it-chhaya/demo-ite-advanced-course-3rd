package co.istad.chanchhaya.ecommerce.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String familyName,
        @NotBlank
        String givenName,
        @NotBlank
        String password,
        @NotBlank
        String confirmedPassword,
        @NotBlank
        String roleId // use , as delimiter
) {
}
