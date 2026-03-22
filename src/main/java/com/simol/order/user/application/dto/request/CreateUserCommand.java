package com.simol.order.user.application.dto.request;

import lombok.Builder;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record CreateUserCommand (
    String name
){
    public static CreateUserCommand of(final String name) {
        return CreateUserCommand.builder()
            .name(name)
            .build();
    }
}
