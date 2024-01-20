package com.recebimento.api.domain.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.recebimento.api.domain.base.entities.BaseEntity;
import com.recebimento.api.domain.users.models.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseConverter;
import org.hibernate.type.YesNoConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    @Column(name = "name", length = 100, nullable = false)
    private String Name;
    @Column(name = "email", unique = true, length = 50, nullable = false)
    private  String Username;
    @Column(name = "status", length = 10, nullable = false)
    @Pattern(regexp = "Ativo|Inativo")
    private String Status;
    @Column(name = "password", length = 100, nullable = false)
    private String Password;
    @Column(name = "profile", length = 3, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfileEnum Profile;
    public  User() {}

    public User(UserModel userModel) {
        ChangeName(userModel.name);
        ChangeUsername(userModel.username);
        ChangeProfile(userModel.profile);
        ChangeStatus(userModel.status);
        ChangePassword(userModel.password);
    }

    public void ChangeName(String name) {
        Name = name;
    }
    public void ChangeUsername(String username) { Username = username; }
    public void ChangeProfile(ProfileEnum profile) {
        Profile = profile;
    }
    public  void ChangeStatus(String status) {
        Status = status != null ? status : "Inativo";;
    }
    public void ChangePassword(String password) {
        Password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    public UserModel ToModel() {
        return new UserModel(Id, Name, Username, Profile, Status, CreatedAt, UpdatedAt, DeletedAt);
    }

}
