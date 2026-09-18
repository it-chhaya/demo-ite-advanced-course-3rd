package co.istad.chanchhaya.ecommerce.order.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.BusinessId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.Money;
import co.istad.chanchhaya.ecommerce.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money price
) {
}
