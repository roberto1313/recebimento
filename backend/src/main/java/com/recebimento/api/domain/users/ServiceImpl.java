package com.recebimento.api.domain.users;

import com.recebimento.api.domain.users.models.UserModel;
import com.recebimento.api.infra.exceptions.ResponsityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ServiceImpl implements IUserService {
    private final IUserRepository Repository;
    public ServiceImpl(IUserRepository repository) {
        Repository = repository;
    }

    @Override
    public ResponseEntity<String> create(UserModel userModel) {
        var user = Repository.getUsername(userModel.username);

        if(Objects.nonNull(user)) {
            return ResponsityException.getResponsiTyMessage("Já existe usuário cadastrado com esse e-mail. Tente novamente.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(validateFormUser(userModel)) {
           return ResponsityException.getResponsiTyMessage("Error ao adicionar o usuário. Verifica se todos os campos obrigatorios foram inseridos. Tente novamente", HttpStatus.BAD_REQUEST);
        } else {
           user = new User(userModel);
           Repository.saveAndFlush(user);
           return ResponsityException.getResponsiTyMessage("Dados adicionado com sucesso!", HttpStatus.CREATED);
        }
    }
    public boolean validateFormUser(UserModel userModel) {
        return !userModel.name.isEmpty() && !userModel.username.isEmpty()
                && !userModel.password.isEmpty() && userModel.status.isEmpty()
                && userModel.profile.getProfile() != null;
    }
}
