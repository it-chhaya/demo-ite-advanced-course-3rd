package co.istad.chanchhaya.ecommerce.order.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.BusinessId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.Money;
import co.istad.chanchhaya.ecommerce.domain.valueobject.StreetAddress;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderCommand(
        UUID customerId,
        UUID businessId,
        BigDecimal price,
        CommandOrderAddress deliveryAddress,
        List<CommandOrderItem> items
) {
}
