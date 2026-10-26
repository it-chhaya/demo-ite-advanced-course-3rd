package co.istad.chanchhaya.ecommerce.user.service.impl;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;
import co.istad.chanchhaya.ecommerce.user.repository.UserRepository;
import co.istad.chanchhaya.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        return null;
    }

}
