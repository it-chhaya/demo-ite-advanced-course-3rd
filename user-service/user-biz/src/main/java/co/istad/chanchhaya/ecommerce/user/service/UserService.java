package co.istad.chanchhaya.ecommerce.user.service;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;
import co.istad.chanchhaya.ecommerce.user.dto.UserUpdateRequest;

public interface UserService {

    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    void deleteById(String id);

    UserResponse getByUsername(String username);
}
