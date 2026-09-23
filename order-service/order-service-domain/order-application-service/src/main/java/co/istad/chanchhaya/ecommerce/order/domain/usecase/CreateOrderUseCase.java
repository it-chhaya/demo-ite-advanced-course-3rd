package co.istad.chanchhaya.ecommerce.order.domain.usecase;

import co.istad.chanchhaya.ecommerce.domain.valueobject.BusinessId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.Money;
import co.istad.chanchhaya.ecommerce.domain.valueobject.ProductId;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;
import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderResult;
import co.istad.chanchhaya.ecommerce.order.domain.entity.Business;
import co.istad.chanchhaya.ecommerce.order.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.order.domain.entity.Product;
import co.istad.chanchhaya.ecommerce.order.domain.exception.OrderDomainException;
import co.istad.chanchhaya.ecommerce.order.domain.port.ouput.BusinessRepository;
import co.istad.chanchhaya.ecommerce.order.domain.port.ouput.CustomerRepository;
import co.istad.chanchhaya.ecommerce.order.domain.port.ouput.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j // logging
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        // Validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Could not find customer with ID: " + createOrderCommand.customerId()));

        // Validate business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .price(new Money(commandOrderItem.price()))
                        .build())
                .toList();

        Business business = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();

        business = businessRepository.findBusiness(business)
                .orElseThrow(() -> new OrderDomainException("Could not find business with ID: " + createOrderCommand.businessId()));

        log.info("Found business: {}", business);

        return new CreateOrderResult(UUID.randomUUID());
    }

}

// INSERT, UPDATE, DELETE -> Command -> TRANSACTION
// SELECT -> Query -> TRANSACTION READ ONLY
// Pattern: CQRS = Command Query Responsibility Segregation