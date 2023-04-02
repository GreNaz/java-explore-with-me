package ru.practicum.ewm.controller.users.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.users.UsersAdminController;
import ru.practicum.ewm.model.users.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;
import ru.practicum.ewm.service.users.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersAdminControllerImpl implements UsersAdminController {

    private final UsersService service;

    public UserDto setUser(NewUserRequest newUserRequest) {
        return service.setUser(newUserRequest);
    }

    public List<UserDto> getUsers(List<Integer> ids, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getUsers(ids, pageable);
    }

    public void deleteUser(Integer userId) {
        service.deleteUser(userId);
    }
}
