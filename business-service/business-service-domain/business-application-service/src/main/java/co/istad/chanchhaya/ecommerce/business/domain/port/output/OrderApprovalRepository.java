package co.istad.chanchhaya.ecommerce.business.domain.port.output;

import co.istad.chanchhaya.ecommerce.business.domain.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);

}
