package com.simol.order.user.application.dto.response;

import com.simol.order.user.domain.User;
import lombok.Builder;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record UserResult(
    Long id,
    String name
) {
    public static UserResult of(final User user) {
        return UserResult.builder()
            .id(user.getId())
            .name(user.getName())
            .build();
    }
}
