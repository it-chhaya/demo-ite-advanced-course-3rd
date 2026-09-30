package co.istad.chanchhaya.ecommerce.customer.domain.dto;

import java.util.UUID;

public record CreateCustomerCommand(
        UUID customerId,
        String username,
        String familyName,
        String givenName,
        String email,
        String phoneNumber
) {
}
