package ru.practicum.ewm.service.users;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface UsersService {

    @Transactional
    UserDto setUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(List<Integer> ids, Pageable pageable);

    HttpStatus deleteUser(Integer userId);
}
