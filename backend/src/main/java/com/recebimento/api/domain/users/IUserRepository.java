package com.recebimento.api.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM users u WHERE u.deleted_at is null and u.email=:username", nativeQuery = true)
    User getUsername(String username);
    @Query(value = "SELECT (id, name, email, status, profile) FROM users u WHERE u.deleted_at is null and u.id=:id", nativeQuery = true)
    User getByKey(@Param("id") String id);
    @Query(value = "SELECT (id, name, email, status, profile) FROM users u WHERE u.deleted_at is null order by u.name asc", nativeQuery = true)
    List<User> search();
}
