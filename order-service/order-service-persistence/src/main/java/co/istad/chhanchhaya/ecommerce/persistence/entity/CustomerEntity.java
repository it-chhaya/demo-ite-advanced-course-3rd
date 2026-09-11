package co.istad.chhanchhaya.ecommerce.persistence.entity;

import jakarta.persistence.Entity;
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
@Table(name = "customers")
public class CustomerEntity {
    @Id
    private UUID id;
    private String username;
    private String familyName;
    private String givenName;
}
