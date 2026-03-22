package com.simol.order.user.application;

import com.simol.order.user.application.dto.request.CreateUserCommand;
import com.simol.order.user.application.dto.response.UserResult;
import com.simol.order.user.domain.User;
import com.simol.order.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserResult createUser(final CreateUserCommand command) {
        final User user = User.of(command.name(), BigDecimal.ZERO);
        userRepository.save(user);
        return UserResult.of(user);
    }
}
