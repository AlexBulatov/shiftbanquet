package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String email;

    private String phone;
    private String avtPath;
}
