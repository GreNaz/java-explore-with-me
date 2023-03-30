package ru.practicum.ewm.controller.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;
import ru.practicum.ewm.service.users.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersAdminControllerImpl implements UsersAdminController {

    private final UsersService service;

    public ResponseEntity<UserDto> setUser(NewUserRequest newUserRequest) {
        return ResponseEntity.status(201).body(service.setUser(newUserRequest));
    }

    public List<UserDto> getUsers(List<Integer> ids, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getUsers(ids, pageable);
    }

    public HttpStatus deleteUser(Integer userId) {
        return service.deleteUser(userId);
    }
}
