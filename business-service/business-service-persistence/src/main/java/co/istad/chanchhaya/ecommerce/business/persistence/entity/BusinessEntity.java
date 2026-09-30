package co.istad.chanchhaya.ecommerce.business.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@IdClass(BusinessIdEntity.class)
@Entity
@Table(name = "businesses")
public class BusinessEntity {
    @Id
    private UUID businessId;

    @Id
    private UUID productId;

    private String businessName;
    private Boolean businessActive;

    private String productName;
    private BigDecimal productPrice;
    private Boolean productAvailable;

}
