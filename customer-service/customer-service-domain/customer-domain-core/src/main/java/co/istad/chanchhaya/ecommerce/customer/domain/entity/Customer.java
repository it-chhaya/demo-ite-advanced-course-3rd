package co.istad.chanchhaya.ecommerce.customer.domain.entity;

import co.istad.chanchhaya.ecommerce.customer.domain.exception.CustomerDomainException;
import co.istad.chanchhaya.ecommerce.domain.entity.AggregateRoot;
import co.istad.chanchhaya.ecommerce.domain.valueobject.*;

import java.util.UUID;

public class Customer extends AggregateRoot<CustomerId> {

    private final String username;
    private String familyName;
    private String givenName;
    private Email email;
    private PhoneNumber phoneNumber;
    private LoyaltyTier loyaltyTier;
    private CustomerStatus status;

    public String getUsername() {
        return username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public LoyaltyTier getLoyaltyTier() {
        return loyaltyTier;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void validateCustomer(){
        validateInitialCustomer();
        validateUsername(username);
        validateEmail(email);
    }

    private void validateEmail(Email email) {
        if (email == null || isBlank(email.value())){
            throw new CustomerDomainException("Email is not valid");
        }
    }

    private void validateUsername(String username) {
        if (isBlank(username)) {
            throw new CustomerDomainException("Username is required");
        }
    }

    private void validateInitialCustomer() {
        if(status != null || super.getId() != null){
            throw new CustomerDomainException("Customer already exists");
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public void initiateCustomer(){
        setId(new CustomerId(UUID.randomUUID()));
        status = CustomerStatus.ACTIVE;
        if(loyaltyTier == null){
            loyaltyTier = LoyaltyTier.BRONZE;
        }
    }

    public void updateCustomer(String familyName, String givenName, Email email, PhoneNumber phoneNumber){
        if(status != CustomerStatus.ACTIVE){
            throw new CustomerDomainException("Customer can not be updated");
        }
        validateEmail(email);
        this.familyName = familyName;
        this.givenName = givenName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void deactivateCustomer(){
        if(status != CustomerStatus.ACTIVE){
            throw new CustomerDomainException("Customer is already deactivated");
        }
        status = CustomerStatus.INACTIVE;
    }

    private Customer(Builder builder) {
        super.setId(builder.id);
        username = builder.username;
        familyName = builder.familyName;
        givenName = builder.givenName;
        email = builder.email;
        phoneNumber = builder.phoneNumber;
        loyaltyTier = builder.loyaltyTier;
        status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CustomerId id;
        private String username;
        private String familyName;
        private String givenName;
        private Email email;
        private PhoneNumber phoneNumber;
        private LoyaltyTier loyaltyTier;
        private CustomerStatus status;

        private Builder() {
        }

        public Builder id(CustomerId val) {
            id = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder familyName(String val) {
            familyName = val;
            return this;
        }

        public Builder givenName(String val) {
            givenName = val;
            return this;
        }

        public Builder email(Email val) {
            email = val;
            return this;
        }

        public Builder phoneNumber(PhoneNumber val) {
            phoneNumber = val;
            return this;
        }

        public Builder loyaltyTier(LoyaltyTier val) {
            loyaltyTier = val;
            return this;
        }

        public Builder status(CustomerStatus val) {
            status = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}


