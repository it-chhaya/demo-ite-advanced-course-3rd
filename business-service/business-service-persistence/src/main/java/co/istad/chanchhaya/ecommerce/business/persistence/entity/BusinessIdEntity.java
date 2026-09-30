package co.istad.chanchhaya.ecommerce.business.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BusinessIdEntity implements Serializable {
    private UUID businessId;
    private UUID productId;
}
