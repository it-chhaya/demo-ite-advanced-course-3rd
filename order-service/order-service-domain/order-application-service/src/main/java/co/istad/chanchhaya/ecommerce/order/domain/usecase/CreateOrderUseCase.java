package co.istad.chanchhaya.ecommerce.order.domain.usecase;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CreateOrderUseCase {

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        // Validate customer

        // Validate business

        return new CreateOrderResult(UUID.randomUUID());
    }

}

// INSERT, UPDATE, DELETE -> Command -> TRANSACTION
// SELECT -> Query -> TRANSACTION READ ONLY
// Pattern: CQRS = Command Query Responsibility Segregation