package co.istad.chhanchhaya.ecommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_addresses")
public class OrderAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private String postalCode;
    private String city;

    @OneToOne(mappedBy = "orderAddress")
    private OrderEntity order;
}
