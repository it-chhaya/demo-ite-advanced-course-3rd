package co.istad.chanchhaya.ecommerce.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "co.istad.chanchhaya.ecommerce.payment.persistence")
@EntityScan(basePackages = "co.istad.chanchhaya.ecommerce.payment.persistence")
@SpringBootApplication(scanBasePackages = "co.istad.chanchhaya.ecommerce.payment.persistence")
public class PaymentServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
