package com.simol.order.user.interfaces.api.dto.response;

import com.simol.order.user.application.dto.response.UserResult;
import lombok.Builder;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record UserResponse (
    Long id,
    String name
){
    public static UserResponse from(final UserResult userResult) {
        return UserResponse.builder()
            .id(userResult.id())
            .name(userResult.name())
            .build();
    }
}
