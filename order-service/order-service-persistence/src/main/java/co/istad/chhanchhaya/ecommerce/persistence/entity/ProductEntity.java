package co.istad.chhanchhaya.ecommerce.persistence.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal price;

    @OneToOne(mappedBy = "product")
    private OrderItemEntity orderItem;
}
