package co.istad.chanchhaya.ecommerce.order.restapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record OrderCreateRequest(
        @NotNull
        UUID customerId,
        @NotNull
        UUID businessId,
        @NotNull
        OrderAddressRequest orderAddress,
        @NotNull
        List<OrderItemRequest> items,
        @NotNull
        BigDecimal price
) {
}
