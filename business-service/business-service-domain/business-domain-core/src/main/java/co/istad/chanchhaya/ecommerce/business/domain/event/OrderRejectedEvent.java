package co.istad.chanchhaya.ecommerce.business.domain.event;

import co.istad.chanchhaya.ecommerce.business.domain.entity.OrderApproval;
import co.istad.chanchhaya.ecommerce.domain.valueobject.BusinessId;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderRejectedEvent extends OrderApprovalEvent {
    public OrderRejectedEvent(OrderApproval orderApproval, BusinessId businessId, List<String> failureMessages, ZonedDateTime createdAt) {
        super(orderApproval, businessId, failureMessages, createdAt);
    }
}
