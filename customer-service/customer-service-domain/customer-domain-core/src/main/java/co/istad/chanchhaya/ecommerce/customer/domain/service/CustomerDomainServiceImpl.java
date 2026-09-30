package co.istad.chanchhaya.ecommerce.customer.domain.service;

import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.customer.domain.event.CustomerCreatedEvent;
import co.istad.chanchhaya.ecommerce.customer.domain.event.CustomerDeactivatedEvent;
import co.istad.chanchhaya.ecommerce.customer.domain.event.CustomerUpdatedEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomerDomainServiceImpl implements CustomerDomainService {

    @Override
    public CustomerCreatedEvent validateAndInitiateCustomer(Customer customer) {
        customer.validateCustomer();
        customer.initiateCustomer();
        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerUpdatedEvent updateCustomer(Customer customer){
        return new CustomerUpdatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerDeactivatedEvent deactivateCustomer(Customer customer) {
        customer.deactivateCustomer();
        return new CustomerDeactivatedEvent(customer.getId(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

}
