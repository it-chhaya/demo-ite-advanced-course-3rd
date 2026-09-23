package co.istad.chanchhaya.ecommerce.order.restapi.mapper;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderResult;
import co.istad.chanchhaya.ecommerce.order.restapi.dto.OrderCreateRequest;
import co.istad.chanchhaya.ecommerce.order.restapi.dto.OrderCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

    // Source = OrderCreateRequest
    // Target = CreateOrderCommand
    @Mapping(source = "orderAddress", target = "deliveryAddress")
    CreateOrderCommand orderCreateRequestToCreateOrderCommand(
            OrderCreateRequest orderCreateRequest
    );

    OrderCreateResponse createOrderResultToOrderCreateResponse(
            CreateOrderResult createOrderResult
    );

}
