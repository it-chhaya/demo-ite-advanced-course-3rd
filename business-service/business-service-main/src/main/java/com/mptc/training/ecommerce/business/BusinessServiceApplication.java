package com.mptc.training.ecommerce.business;

import co.istad.chanchhaya.ecommerce.business.persistence.entity.BusinessEntity;
import co.istad.chanchhaya.ecommerce.business.persistence.repository.BusinessJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@EntityScan(basePackages = {"co.istad.chanchhaya.ecommerce.business.persistence"})
@EnableJpaRepositories(basePackages = {"co.istad.chanchhaya.ecommerce.business.persistence"})
@SpringBootApplication
public class BusinessServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(BusinessServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(BusinessJpaRepository businessRepository) {
        return args -> {
            UUID businessId = UUID.randomUUID();

            BusinessEntity firstProduct = new BusinessEntity();
            firstProduct.setBusinessId(businessId);
            firstProduct.setProductId(UUID.randomUUID());
            firstProduct.setBusinessName("Office Supply");
            firstProduct.setBusinessActive(true);
            firstProduct.setProductName("Office Chair");
            firstProduct.setProductPrice(new BigDecimal("120"));
            firstProduct.setProductAvailable(true);
            businessRepository.save(firstProduct);

            BusinessEntity secondProduct = new BusinessEntity();
            secondProduct.setBusinessId(businessId);
            secondProduct.setProductId(UUID.randomUUID());
            secondProduct.setBusinessName("Office Supply");
            secondProduct.setBusinessActive(true);
            secondProduct.setProductName("Desk Lamp");
            secondProduct.setProductPrice(new BigDecimal("35"));
            secondProduct.setProductAvailable(true);
            businessRepository.save(secondProduct);

            log.info("Seeded businessId={}, productIds={}, {}", businessId, firstProduct.getProductId(), secondProduct.getProductId());
        };
    }
}
