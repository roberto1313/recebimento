package com.recebimento.api.domain.base.models;

import java.time.LocalDateTime;

public class BaseModel {
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;

    public BaseModel() {}

    public BaseModel(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
