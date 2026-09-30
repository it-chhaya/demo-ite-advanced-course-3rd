package co.istad.chanchhaya.ecommerce.payment;

import co.istad.chanchhaya.ecommerce.payment.domain.PaymentDomainService;
import co.istad.chanchhaya.ecommerce.payment.domain.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }
}
