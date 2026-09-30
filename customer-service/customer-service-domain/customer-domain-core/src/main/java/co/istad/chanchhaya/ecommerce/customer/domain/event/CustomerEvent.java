package co.istad.chanchhaya.ecommerce.customer.domain.event;

import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.domain.event.DomainEvent;

public abstract class CustomerEvent implements DomainEvent<Customer> {
    private final Customer customer;

    public CustomerEvent(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
