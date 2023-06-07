package ru.practicum.ewm.service.users;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.users.dto.NewUserRequest;
import ru.practicum.ewm.model.users.dto.UserDto;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface UsersService {

    @Transactional
    UserDto setUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(List<Long> ids, Pageable pageable);

    void deleteUser(Long userId);
}
