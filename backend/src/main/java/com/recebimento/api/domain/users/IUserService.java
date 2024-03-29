package com.recebimento.api.domain.users;

import com.recebimento.api.domain.users.models.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<String> create(UserModel userModel);
    ResponseEntity<String> update(UserModel userModel) throws Exception;
    List<UserModel> search();


}
