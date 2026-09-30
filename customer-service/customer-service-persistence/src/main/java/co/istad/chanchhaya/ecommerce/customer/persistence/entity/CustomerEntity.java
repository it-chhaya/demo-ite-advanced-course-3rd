package co.istad.chanchhaya.ecommerce.customer.persistence.entity;

import co.istad.chanchhaya.ecommerce.domain.valueobject.CustomerStatus;
import co.istad.chanchhaya.ecommerce.domain.valueobject.LoyaltyTier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    private UUID id;

    @Column(unique = true)
    private String username;

    private String familyName;

    private String givenName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LoyaltyTier loyaltyTier;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
}
