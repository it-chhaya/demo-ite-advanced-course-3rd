package co.istad.chanchhaya.ecommerce.order.domain.port.ouput;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusiness(Business business);

}
