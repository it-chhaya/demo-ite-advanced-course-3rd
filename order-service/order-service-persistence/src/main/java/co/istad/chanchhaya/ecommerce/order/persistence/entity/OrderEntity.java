package co.istad.chanchhaya.ecommerce.order.persistence.entity;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

// JPA Entity must be POJO (Plain Old Java Object) class
@Getter
@Setter
@NoArgsConstructor
@Entity // Create table name = order
@Table(name = "orders")
public class OrderEntity {
    @Id
    private UUID id;

    private UUID customerId;

    private UUID businessId;

    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderAddressEntity orderAddress;

    private UUID trackingId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String failureMessages; // message1;message2

}
