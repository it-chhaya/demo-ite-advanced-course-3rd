package co.istad.chanchhaya.ecommerce.payment.domain.ports.output.repository;

import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
