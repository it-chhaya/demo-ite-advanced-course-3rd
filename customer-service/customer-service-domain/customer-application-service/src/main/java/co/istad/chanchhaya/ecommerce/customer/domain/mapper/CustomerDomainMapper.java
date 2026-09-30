package co.istad.chanchhaya.ecommerce.customer.domain.mapper;

import co.istad.chanchhaya.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.istad.chanchhaya.ecommerce.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerDomainMapper {

    @Mapping(source = "email", target = "email.value")
    @Mapping(source = "phoneNumber", target = "phoneNumber.value")
    Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand);

}
