package co.istad.chanchhaya.ecommerce.order.persistence.adapter;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.order.domain.port.ouput.CustomerRepository;
import co.istad.chanchhaya.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import co.istad.chanchhaya.ecommerce.order.persistence.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId)
                .map(orderPersistenceMapper::customerEntityToCustomer);
    }

}
