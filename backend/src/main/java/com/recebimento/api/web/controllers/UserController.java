package com.recebimento.api.web.controllers;

import com.recebimento.api.domain.users.IUserService;
import com.recebimento.api.domain.users.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService) { this.userService = userService; }
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }
    @GetMapping("/search")
    public List<UserModel> search() {
        return userService.search();
    }
}
