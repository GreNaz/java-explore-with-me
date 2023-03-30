package ru.practicum.ewm.controller.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.model.requests.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;
import ru.practicum.ewm.service.users.UsersService;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
public class UsersAdminControllerImpl implements UsersAdminController {
    private final UsersService service;

    public List<UserDto> getUser(
            List<Integer> ids,
            Integer from,
            Integer size
    ) {
        return null;
    }

    public ResponseEntity<UserDto> setUser(
            NewUserRequest newUserRequest) {
        return ResponseEntity
                .status(201)
                .body(service.setUser(newUserRequest));
    }


    @DeleteMapping("{userId}")
    public HttpStatus deleteUser(
            @PathVariable Integer userId) {
        return null;
    }
}
