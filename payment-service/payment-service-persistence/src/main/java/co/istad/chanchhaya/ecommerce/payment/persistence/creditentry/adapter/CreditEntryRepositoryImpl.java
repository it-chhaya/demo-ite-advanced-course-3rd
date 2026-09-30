package co.istad.chanchhaya.ecommerce.payment.persistence.creditentry.adapter;

import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerId;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditEntry;
import co.istad.chanchhaya.ecommerce.payment.persistence.creditentry.mapper.CreditEntryPersistenceMapper;
import co.istad.chanchhaya.ecommerce.payment.persistence.creditentry.repository.CreditEntryJpaRepository;
import co.istad.chanchhaya.ecommerce.payment.domain.ports.output.repository.CreditEntryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreditEntryRepositoryImpl implements CreditEntryRepository {

    private final CreditEntryJpaRepository creditEntryJpaRepository;
    private final CreditEntryPersistenceMapper creditEntryPersistenceMapper;

    public CreditEntryRepositoryImpl(CreditEntryJpaRepository creditEntryJpaRepository,
                                     CreditEntryPersistenceMapper creditEntryPersistenceMapper) {
        this.creditEntryJpaRepository = creditEntryJpaRepository;
        this.creditEntryPersistenceMapper = creditEntryPersistenceMapper;
    }

    @Override
    public CreditEntry save(CreditEntry creditEntry) {
        return creditEntryPersistenceMapper
                .creditEntryEntityToCreditEntry(creditEntryJpaRepository
                        .save(creditEntryPersistenceMapper.creditEntryToCreditEntryEntity(creditEntry)));
    }

    @Override
    public Optional<CreditEntry> findByCustomerId(CustomerId customerId) {
        return creditEntryJpaRepository
                .findByCustomerId(customerId.value())
                .map(creditEntryPersistenceMapper::creditEntryEntityToCreditEntry);
    }
}
