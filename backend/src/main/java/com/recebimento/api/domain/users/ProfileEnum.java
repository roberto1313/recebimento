package com.recebimento.api.domain.users;
import lombok.Getter;
public enum ProfileEnum {
    MASTER(1, "MASTER"),
    ADMIN(2, "ADMIN"),
    USER(3, "USER");

    @Getter
    private Integer value = null;
    private final String profile;
    ProfileEnum(int value, String profile) {
        this.value = value;
        this.profile = profile;
    }
    public void getProfile(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return profile;
    }
}
