package co.istad.chanchhaya.ecommerce.customer.persistence.repository;

import co.istad.chanchhaya.ecommerce.customer.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
