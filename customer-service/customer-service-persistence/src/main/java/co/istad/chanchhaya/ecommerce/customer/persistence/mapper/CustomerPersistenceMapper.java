package co.istad.chanchhaya.ecommerce.customer.persistence.mapper;

import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.customer.persistence.entity.CustomerEntity;
import co.istad.chanchhaya.ecommerce.domain.valueobject.PhoneNumber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    @Mapping(source="id.value", target = "id")
    @Mapping(source="email.value", target = "email")
    @Mapping(source="phoneNumber.value", target = "phoneNumber")
    CustomerEntity customerToCustomerEntity(Customer customer);


    @Mapping(source="id", target = "id.value")
    @Mapping(source="email", target = "email.value")
    @Mapping(source = "phoneNumber", target = "phoneNumber", qualifiedByName = "toPhoneNumber")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);

    @Named("toPhoneNumber")
    default PhoneNumber toPhoneNumber(String phoneNumber) {
        return phoneNumber == null ? null : new PhoneNumber(phoneNumber);
    }

}
