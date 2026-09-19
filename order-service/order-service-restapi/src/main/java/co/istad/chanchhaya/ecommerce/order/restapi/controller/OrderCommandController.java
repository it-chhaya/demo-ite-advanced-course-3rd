package co.istad.chanchhaya.ecommerce.order.restapi.controller;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderResult;
import co.istad.chanchhaya.ecommerce.order.domain.usecase.CreateOrderUseCase;
import co.istad.chanchhaya.ecommerce.order.restapi.dto.OrderCreateRequest;
import co.istad.chanchhaya.ecommerce.order.restapi.dto.OrderCreateResponse;
import co.istad.chanchhaya.ecommerce.order.restapi.mapper.OrderWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    // Declare required dependency
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest orderCreateRequest
    ) {
        // Mapping logic
        CreateOrderCommand createOrderCommand = orderWebMapper
                .orderCreateRequestToCreateOrderCommand(orderCreateRequest);

        // UseCase logic
        CreateOrderResult createOrderResult = createOrderUseCase.execute(createOrderCommand);

        // Mapping logic
        return orderWebMapper.createOrderResultToOrderCreateResponse(createOrderResult);
    }

}
