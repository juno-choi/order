package com.simol.order.user.interfaces.api;

import com.simol.order.user.application.UserService;
import com.simol.order.user.application.dto.request.CreateUserCommand;
import com.simol.order.user.application.dto.response.UserResult;
import com.simol.order.user.interfaces.api.dto.request.CreateUserRequest;
import com.simol.order.user.interfaces.api.dto.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid final CreateUserRequest request) {
        final CreateUserCommand command = request.toCommand();
        final UserResult userResult = userService.createUser(command);
        return UserResponse.from(userResult);
    }
}
