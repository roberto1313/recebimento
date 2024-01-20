package com.recebimento.api.web.controllers;

import com.recebimento.api.domain.users.IUserService;
import com.recebimento.api.domain.users.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) { this.userService = userService; }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }
}
