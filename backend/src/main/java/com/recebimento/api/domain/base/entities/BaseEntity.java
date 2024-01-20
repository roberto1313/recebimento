package com.recebimento.api.domain.base.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jdk.jfr.Timestamp;
import java.time.LocalDateTime;

import static com.recebimento.api.infra.exensions.DateTimeExtensions.BrazilTimeZone;

@MappedSuperclass
public class BaseEntity {
    @Timestamp
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    protected LocalDateTime CreatedAt;
    @Timestamp
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    protected LocalDateTime UpdatedAt;
    @Timestamp
    @Column(name = "Deleted_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    protected LocalDateTime DeletedAt;

    public BaseEntity() {
        CreatedAt = BrazilTimeZone();
    }
    public void MarkAsUpdated() {
        UpdatedAt = BrazilTimeZone();
    }
    public void MarkAsDeleted() {
        DeletedAt = BrazilTimeZone();
    }
}
