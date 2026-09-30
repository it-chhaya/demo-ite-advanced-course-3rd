package com.mptc.training.ecommerce.business.config;

import co.istad.chanchhaya.ecommerce.business.domain.service.BusinessDomainService;
import co.istad.chanchhaya.ecommerce.business.domain.service.BusinessDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BusinessDomainService businessDomainService() {
        return new BusinessDomainServiceImpl();
    }
}
