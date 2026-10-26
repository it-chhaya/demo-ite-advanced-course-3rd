package co.istad.chanchhaya.ecommerce.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;
    @Column(unique = true, nullable = false)
    private String username;
    private String gender;
    private Date birthday;
    @Column(unique = true)
    private String mobilePhone;
    private String address;
}
