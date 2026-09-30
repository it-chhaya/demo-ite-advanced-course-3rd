package co.istad.chanchhaya.ecommerce.customer.domain.dto;

import java.util.UUID;

public record UpdateCustomerCommand(
        UUID customerId,
        String familyName,
        String givenName,
        String email,
        String phoneNumber
) {
}
