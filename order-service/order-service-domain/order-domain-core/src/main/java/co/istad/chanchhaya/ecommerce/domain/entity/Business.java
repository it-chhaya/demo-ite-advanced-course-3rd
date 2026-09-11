package co.istad.chanchhaya.ecommerce.domain.entity;

import co.istad.chanchhaya.ecommerce.domain.valueobject.BusinessId;

import java.util.List;

public class Business extends AggregateRoot<BusinessId> {
    private final List<Product> products;
    private final boolean active;

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }

    private Business(Builder builder) {
        super.setId(builder.id);
        products = builder.products;
        active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private BusinessId id;
        private List<Product> products;
        private boolean active;

        private Builder() {
        }

        public Builder id(BusinessId val) {
            id = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Business build() {
            return new Business(this);
        }
    }
}
