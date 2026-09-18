package co.istad.chanchhaya.ecommerce.order.domain.entity;

import co.istad.chanchhaya.ecommerce.domain.entity.AggregateRoot;
import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    private final String username;
    private final String familyName;
    private final String givenName;

    public String getUsername() {
        return username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    private Customer(Builder builder) {
        super.setId(builder.id);
        username = builder.username;
        familyName = builder.familyName;
        givenName = builder.givenName;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private CustomerId id;
        private String username;
        private String familyName;
        private String givenName;

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

        public Customer build() {
            return new Customer(this);
        }
    }
}
