package ru.practicum.ewm.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;

import java.util.List;

public class UsersAdminControllerImpl implements UsersAdminController {
    @GetMapping()
    public List<UserDto> getUser(
            @RequestParam List<Integer> ids,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return null;
    }

    @PostMapping
    public UserDto setUser(
            @RequestBody NewUserRequest newUserRequest) {
        return null;
    }

    @DeleteMapping("{userId}")
    public HttpStatus deleteUser(
            @PathVariable Integer userId) {
        return null;
    }
}
