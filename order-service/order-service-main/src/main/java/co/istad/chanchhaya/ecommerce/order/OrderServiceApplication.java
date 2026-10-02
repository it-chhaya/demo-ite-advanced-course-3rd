package co.istad.chanchhaya.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "co.istad.chanchhaya.ecommerce.order.persistence"
})
@EnableJpaRepositories(basePackages = {
        "co.istad.chanchhaya.ecommerce.order.persistence"
})
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
