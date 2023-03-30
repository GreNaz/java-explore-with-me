package ru.practicum.ewm.service.users;

import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;

public interface UsersService {
    UserDto setUser(NewUserRequest newUserRequest);
}
