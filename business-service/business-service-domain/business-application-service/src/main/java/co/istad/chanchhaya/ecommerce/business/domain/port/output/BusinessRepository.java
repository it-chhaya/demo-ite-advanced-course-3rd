package co.istad.chanchhaya.ecommerce.business.domain.port.output;

import co.istad.chanchhaya.ecommerce.business.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusinessInformation(Business business);

}
