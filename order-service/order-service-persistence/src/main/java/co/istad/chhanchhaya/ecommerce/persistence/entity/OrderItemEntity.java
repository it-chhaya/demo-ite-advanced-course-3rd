package co.istad.chhanchhaya.ecommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increase
    private Integer id;

    private UUID productId;

    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    @ManyToOne
    private OrderEntity order;

}
