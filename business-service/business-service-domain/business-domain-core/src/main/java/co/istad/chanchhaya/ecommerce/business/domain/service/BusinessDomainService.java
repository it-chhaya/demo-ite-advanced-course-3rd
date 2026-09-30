package co.istad.chanchhaya.ecommerce.business.domain.service;

import co.istad.chanchhaya.ecommerce.business.domain.entity.Business;
import co.istad.chanchhaya.ecommerce.business.domain.event.OrderApprovalEvent;

import java.util.List;

public interface BusinessDomainService {
    OrderApprovalEvent validateOrder(Business business, List<String> failureMessages);
}
