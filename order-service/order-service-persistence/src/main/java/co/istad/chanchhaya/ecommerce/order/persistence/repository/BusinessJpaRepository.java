package co.istad.chanchhaya.ecommerce.order.persistence.repository;

import co.istad.chanchhaya.ecommerce.order.persistence.entity.BusinessEntity;
import co.istad.chanchhaya.ecommerce.order.persistence.entity.BusinessIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessJpaRepository extends JpaRepository<BusinessEntity, BusinessIdEntity> {

    // Find by business ID and collection of product ID
    List<BusinessEntity> findByBusinessIdAndProductIdIn(
            UUID businessId,
            List<UUID> productIds
    );

}
