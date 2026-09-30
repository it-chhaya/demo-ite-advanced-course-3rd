package co.istad.chanchhaya.ecommerce.customer.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerUpdateRequest(
        String familyName,
        String givenName,
        @NotBlank
        @Email
        String email,
        String phoneNumber
) {
}
