package co.istad.chanchhaya.ecommerce.user.service;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;

public interface UserService {

    UserResponse create(UserCreateRequest userCreateRequest);

}
