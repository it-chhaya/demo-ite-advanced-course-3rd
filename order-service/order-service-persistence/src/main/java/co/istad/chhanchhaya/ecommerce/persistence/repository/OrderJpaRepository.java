package co.istad.chhanchhaya.ecommerce.persistence.repository;


import co.istad.chhanchhaya.ecommerce.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
