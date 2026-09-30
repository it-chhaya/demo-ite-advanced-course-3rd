package co.istad.chanchhaya.ecommerce.customer.domain.event;

import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.domain.event.DomainEvent;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;

import java.time.ZonedDateTime;

public class CustomerDeactivatedEvent implements DomainEvent<Customer> {
    private final CustomerId customerId;
    private final ZonedDateTime deactivatedAt;

    public CustomerDeactivatedEvent(CustomerId customerId, ZonedDateTime deactivatedAt){
        this.customerId = customerId;
        this.deactivatedAt = deactivatedAt;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public ZonedDateTime getDeactivatedAt() {
        return deactivatedAt;
    }
}
