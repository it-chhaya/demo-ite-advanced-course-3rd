package co.istad.chanchhaya.ecommerce.order.domain.mapper;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CommandOrderItem;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;
import co.istad.chanchhaya.ecommerce.order.domain.entity.Order;
import co.istad.chanchhaya.ecommerce.order.domain.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDomainMapper {

    @Mapping(source = "customerId", target = "customerId.value")
    @Mapping(source = "businessId", target = "businessId.value")
    @Mapping(source = "price", target = "price.amount")
    Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand);

    @Mapping(source = "productId", target = "product.id.value")
    @Mapping(source = "price", target = "price.amount")
    @Mapping(source = "subTotal", target = "subTotal.amount")
    OrderItem commandOrderItemToOrderItem(CommandOrderItem commandOrderItem);

}
