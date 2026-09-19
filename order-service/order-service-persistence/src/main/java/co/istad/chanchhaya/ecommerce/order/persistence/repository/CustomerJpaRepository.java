package co.istad.chanchhaya.ecommerce.order.persistence.repository;

import co.istad.chanchhaya.ecommerce.order.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
}
