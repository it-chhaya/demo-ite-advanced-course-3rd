package co.istad.chanchhaya.ecommerce.customer.domain.usecase;

import co.istad.chanchhaya.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import co.istad.chanchhaya.ecommerce.customer.domain.dto.UpdateCustomerResult;
import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.customer.domain.event.CustomerUpdatedEvent;
import co.istad.chanchhaya.ecommerce.customer.domain.exception.CustomerDomainException;
import co.istad.chanchhaya.ecommerce.customer.domain.mapper.CustomerDomainMapper;
import co.istad.chanchhaya.ecommerce.customer.domain.port.output.CustomerRepository;
import co.istad.chanchhaya.ecommerce.customer.domain.service.CustomerDomainService;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.domain.valueobject.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Use case: change an existing customer's name, email and phone number.
// Called by the REST API controller (PUT /api/v1/customers/{customerId}).
// Flow: load customer -> check new email -> domain updates -> save -> return id
@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateCustomerUseCase {

    private final CustomerDomainService customerDomainService;
    private final CustomerRepository customerRepository;
    private final CustomerDomainMapper customerDomainMapper;

    @Transactional
    public UpdateCustomerResult execute(UpdateCustomerCommand updateCustomerCommand) {

        Customer customer = customerRepository.findById(new CustomerId(updateCustomerCommand.customerId()))
                .orElseThrow(() -> new CustomerDomainException(
                        "Customer not found: " + updateCustomerCommand.customerId()));

        Email newEmail = new Email(updateCustomerCommand.email());

        if (!newEmail.equals(customer.getEmail()) && customerRepository.existsByEmail(newEmail.value())) {
            throw new CustomerDomainException("Email already exists");
        }

        CustomerUpdatedEvent customerUpdatedEvent = customerDomainService.updateCustomer(customer);
        Customer savedCustomer = customerRepository.save(customer);

        log.info("Customer updated with id: {} at {}",
                savedCustomer.getId().value(), customerUpdatedEvent.getUpdatedAt());
        return new UpdateCustomerResult(savedCustomer.getId().value());
    }
}
