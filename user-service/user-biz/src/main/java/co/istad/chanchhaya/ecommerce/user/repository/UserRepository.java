package co.istad.chanchhaya.ecommerce.user.repository;

import co.istad.chanchhaya.ecommerce.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
