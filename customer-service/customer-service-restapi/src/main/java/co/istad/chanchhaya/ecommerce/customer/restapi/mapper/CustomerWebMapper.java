package co.istad.chanchhaya.ecommerce.customer.restapi.mapper;

import co.istad.chanchhaya.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.istad.chanchhaya.ecommerce.customer.domain.dto.CreateCustomerResult;
import co.istad.chanchhaya.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import co.istad.chanchhaya.ecommerce.customer.domain.dto.UpdateCustomerResult;
import co.istad.chanchhaya.ecommerce.customer.restapi.dto.CustomerCreateRequest;
import co.istad.chanchhaya.ecommerce.customer.restapi.dto.CustomerCreateResponse;
import co.istad.chanchhaya.ecommerce.customer.restapi.dto.CustomerUpdateRequest;
import co.istad.chanchhaya.ecommerce.customer.restapi.dto.CustomerUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CustomerWebMapper {
    CreateCustomerCommand customerCreateRequestToCreateCustomerCommand(CustomerCreateRequest customerCreateRequest);
    CustomerCreateResponse createCustomerResultToCustomerCreateResponse(CreateCustomerResult createCustomerResult);

    // customerId comes from the path, the rest from the request body
    @Mapping(source = "customerId", target = "customerId")
    UpdateCustomerCommand customerUpdateRequestToUpdateCustomerCommand(UUID customerId, CustomerUpdateRequest customerUpdateRequest);
    CustomerUpdateResponse updateCustomerResultToCustomerUpdateResponse(UpdateCustomerResult updateCustomerResult);
}
