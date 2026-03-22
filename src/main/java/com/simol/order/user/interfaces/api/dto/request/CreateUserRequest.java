package com.simol.order.user.interfaces.api.dto.request;

import com.simol.order.user.application.dto.request.CreateUserCommand;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest (
    @NotNull(message = "name 필수값 입니다")
    String name
){
    public CreateUserCommand toCommand() {
        return CreateUserCommand.of(name);
    }
}
