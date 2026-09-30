package co.istad.chanchhaya.ecommerce.customer.domain.port.output;

import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;

import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(CustomerId customerId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
