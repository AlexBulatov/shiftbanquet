package ru.cft.shiftbanquet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class AppUser {

    @Id
    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private String username;

    @NonNull
    private String email;

    private String phone;
    private String avtPath;
}
