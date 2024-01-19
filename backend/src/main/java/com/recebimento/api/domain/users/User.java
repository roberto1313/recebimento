package com.recebimento.api.domain.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.recebimento.api.domain.base.entities.BaseEntity;
import com.recebimento.api.domain.users.models.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

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
    @Column(name = "username", length = 100, nullable = false)
    private String Username;
    @Column(name = "email", length = 50, nullable = false)
    private  String Email;
    @Column(name = "status", length = 10, nullable = false)
    private Boolean Status;
    @Column(name = "password", length = 100, nullable = false)
    private String Password;
    @Column(name = "profile", length = 3, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProfileEnum Profile;
    public  User() {}

    public User(String name, ProfileEnum profile, Boolean status, String password) {
        ChangeName(name);
        ChangeProfile(profile);
        ChangeStatus(status);
        ChagePassword(password);
    }

    public void ChangeName(String name) {
        Username = name;
    }
    public void ChangeProfile(ProfileEnum profile) {
        Profile = profile;
    }
    public  void ChangeStatus(Boolean status) {
        Status = status;
    }
    public void ChagePassword(String password) {
        Password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public UserModel ToMOdel() {
        return new UserModel(Id, Username, Profile, Status, CreatedAt, UpdatedAt, DeletedAt);
    }
}
