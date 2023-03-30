package ru.practicum.ewm.service.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.User;
import ru.practicum.ewm.model.users.UserDto;
import ru.practicum.ewm.model.users.UserMapper;
import ru.practicum.ewm.repository.users.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;

    @Override
    public UserDto setUser(NewUserRequest newUserRequest) {
        User newUser = repository.save(UserMapper.toUser(newUserRequest));
        return UserMapper.toUserDto(newUser);
    }
}
