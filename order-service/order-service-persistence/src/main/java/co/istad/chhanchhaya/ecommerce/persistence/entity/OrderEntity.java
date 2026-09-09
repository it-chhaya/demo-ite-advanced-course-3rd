package co.istad.chhanchhaya.ecommerce.persistence.entity;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity // Create table name = order
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID customerId;

    private UUID businessId;

    private BigDecimal price;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;

    @OneToOne
    private StreetAddressEntity streetAddress;

    private UUID trackingId;

    private OrderStatus orderStatus;

    private String failureMessages; // message1;message2

}
