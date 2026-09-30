package co.istad.chanchhaya.ecommerce.business.persistence.entity;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderApprovalStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_approvals")
public class OrderApprovalEntity {
    @Id
    private UUID id;

    private UUID businessId;
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private OrderApprovalStatus status;
}
