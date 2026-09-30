package co.istad.chanchhaya.ecommerce.customer.domain.usecase;

import co.istad.chanchhaya.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.istad.chanchhaya.ecommerce.customer.domain.dto.CreateCustomerResult;
import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.customer.domain.event.CustomerCreatedEvent;
import co.istad.chanchhaya.ecommerce.customer.domain.exception.CustomerDomainException;
import co.istad.chanchhaya.ecommerce.customer.domain.mapper.CustomerDomainMapper;
import co.istad.chanchhaya.ecommerce.customer.domain.port.output.CustomerRepository;
import co.istad.chanchhaya.ecommerce.customer.domain.service.CustomerDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerDomainService customerDomainService; // business rules (from customer-domain-core)
    private final CustomerRepository customerRepository;
    private final CustomerDomainMapper customerDomainMapper;

    @Transactional
    public CreateCustomerResult execute(CreateCustomerCommand createCustomerCommand) {
        log.info("Execute CreateCustomerUseCase : {}", createCustomerCommand);

        if (customerRepository.existsByUsername(createCustomerCommand.username())) {
            throw new CustomerDomainException("Username already exists");
        }
        if (customerRepository.existsByEmail(createCustomerCommand.email())) {
            throw new CustomerDomainException("Email already exists");
        }

        Customer customer = customerDomainMapper.createCustomerCommandToCustomer(createCustomerCommand);
        CustomerCreatedEvent customerCreatedEvent = customerDomainService.validateAndInitiateCustomer(customer);
        Customer savedCustomer = customerRepository.save(customer);

        if (savedCustomer == null) {
            log.error("Could not save customer with id: {}", createCustomerCommand.customerId());
            throw new CustomerDomainException("Could not save customer with id " + createCustomerCommand.customerId());
        }

        return new CreateCustomerResult(savedCustomer.getId().value());
    }
}
