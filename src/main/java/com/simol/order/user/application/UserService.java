package com.simol.order.user.application;

import com.simol.order.user.application.dto.request.CreateUserCommand;
import com.simol.order.user.application.dto.response.UserResult;

public interface UserService {
    UserResult createUser(final CreateUserCommand command);
}
