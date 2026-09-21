package co.istad.chanchhaya.ecommerce.order.persistence.mapper;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Customer;
import co.istad.chanchhaya.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    @Mapping(source = "id", target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);


}
