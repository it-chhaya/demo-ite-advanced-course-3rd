package co.istad.chanchhaya.ecommerce.customer;

import co.istad.chanchhaya.ecommerce.customer.domain.service.CustomerDomainService;
import co.istad.chanchhaya.ecommerce.customer.domain.service.CustomerDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// How to configure bean
// 1. Annotation based
// 2. Java based (method)
@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerDomainService customerDomainService() {
        return new CustomerDomainServiceImpl();
    }

}
