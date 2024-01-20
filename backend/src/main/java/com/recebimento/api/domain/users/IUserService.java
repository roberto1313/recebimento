package com.recebimento.api.domain.users;

import com.recebimento.api.domain.users.models.UserModel;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<String> create(UserModel userModel);
}
