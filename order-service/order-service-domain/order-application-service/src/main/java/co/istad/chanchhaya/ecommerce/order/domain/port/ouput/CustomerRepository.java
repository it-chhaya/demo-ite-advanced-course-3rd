package co.istad.chanchhaya.ecommerce.order.domain.port.ouput;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);

}
