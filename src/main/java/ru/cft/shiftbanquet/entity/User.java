package ru.cft.shiftbanquet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @NonNull
    private String login;

    @JsonIgnore
    @NonNull
    private String password;
    @NonNull
    private String username;
    @Email
    @NonNull
    private String email;

    private String phone;
    private String avtPath;
}
