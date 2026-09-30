package co.istad.chanchhaya.ecommerce.business.persistence.repository;

import co.istad.chanchhaya.ecommerce.business.persistence.entity.BusinessEntity;
import co.istad.chanchhaya.ecommerce.business.persistence.entity.BusinessIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessJpaRepository extends JpaRepository<BusinessEntity, BusinessIdEntity> {

    List<BusinessEntity> findByBusinessIdAndProductIdIn(
            UUID businessId,
            List<UUID> productIds
    );
}
