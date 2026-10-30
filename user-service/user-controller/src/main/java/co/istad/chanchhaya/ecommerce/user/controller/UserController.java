package co.istad.chanchhaya.ecommerce.user.controller;

import co.istad.chanchhaya.ecommerce.user.dto.UserCreateRequest;
import co.istad.chanchhaya.ecommerce.user.dto.UserResponse;
import co.istad.chanchhaya.ecommerce.user.dto.UserUpdateRequest;
import co.istad.chanchhaya.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }


    @PatchMapping("/{id}")
    public UserResponse update(@PathVariable String id,
                               @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.update(id, userUpdateRequest);
    }


    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        return userService.getById(id);
    }


    @GetMapping("/username/{username}")
    public UserResponse getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }


}
