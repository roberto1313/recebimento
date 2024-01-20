package com.recebimento.api.domain.users;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ProfileEnum {
    MASTER("MASTER", 1),
    ADMIN("ADMIN", 2),
    USER("USER", 3);

    @Getter
    private final String value;
    private final Integer profile;

    ProfileEnum(String value, Integer profile) {
        this.profile = profile;
        this.value = value;
    }
}
