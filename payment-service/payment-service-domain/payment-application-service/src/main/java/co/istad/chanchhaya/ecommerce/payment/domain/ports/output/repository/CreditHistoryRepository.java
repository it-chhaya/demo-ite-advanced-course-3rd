package co.istad.chanchhaya.ecommerce.payment.domain.ports.output.repository;

import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
