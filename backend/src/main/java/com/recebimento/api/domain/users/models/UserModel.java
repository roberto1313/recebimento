package com.recebimento.api.domain.users.models;

import com.recebimento.api.domain.base.models.BaseModel;
import com.recebimento.api.domain.users.ProfileEnum;

import java.time.LocalDateTime;

public class UserModel extends BaseModel {
    public String id;
    public String name;
    public String username;
    public String password;
    public ProfileEnum profile;
    public String status;

    public UserModel(String id, String name, String username, ProfileEnum profile, String status, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        super(createdAt, updatedAt, deletedAt);
        this.id = id;
        this.name = name;
        this.username = username;
        this.profile = profile;
        this.status = status;
    }
}
