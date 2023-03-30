package ru.practicum.ewm.service.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.User;
import ru.practicum.ewm.model.users.UserDto;
import ru.practicum.ewm.model.users.UserMapper;
import ru.practicum.ewm.repository.users.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;

    @Override
    public UserDto setUser(NewUserRequest newUserRequest) {
        User newUser = repository.save(UserMapper.toUser(newUserRequest));
        return UserMapper.toUserDto(newUser);
    }

    @Override
    public List<UserDto> getUsers(List<Integer> ids, Pageable pageable) {
        if (!ids.isEmpty()) {
            return repository.findAllByIdIn(ids, pageable).stream()
                    .map(UserMapper::toUserDto)
                    .collect(Collectors.toList());
        } else {
            return repository.findAll(pageable).stream()
                    .map(UserMapper::toUserDto)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public HttpStatus deleteUser(Integer userId) {
        repository.deleteById(userId);
        return HttpStatus.NO_CONTENT;
    }
}
