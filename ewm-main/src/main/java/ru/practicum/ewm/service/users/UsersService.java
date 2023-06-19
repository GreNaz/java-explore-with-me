package ru.practicum.ewm.service.users;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.model.users.dto.NewUserRequest;
import ru.practicum.ewm.model.users.dto.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface UsersService {

    @Transactional
    UserDto setUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(List<Long> ids, Pageable pageable);

    List<UserDto> getUsers(Pageable pageable);

    void deleteUser(Long userId);
}
