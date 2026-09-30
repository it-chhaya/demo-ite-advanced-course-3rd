package co.istad.chanchhaya.ecommerce.payment.persistence.creditentry.mapper;


import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditEntry;
import co.istad.chanchhaya.ecommerce.payment.persistence.creditentry.entity.CreditEntryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditEntryPersistenceMapper {
    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "customerId.value", target = "customerId")
    @Mapping(source = "totalCreditAmount.amount", target = "totalCreditAmount")
    CreditEntryEntity creditEntryToCreditEntryEntity(CreditEntry creditEntry);

    @Mapping(target = "creditEntryId.value", source = "id")
    @Mapping(target = "customerId.value", source = "customerId")
    @Mapping(target = "totalCreditAmount.amount", source = "totalCreditAmount")
    CreditEntry creditEntryEntityToCreditEntry(CreditEntryEntity creditEntryEntity);
}