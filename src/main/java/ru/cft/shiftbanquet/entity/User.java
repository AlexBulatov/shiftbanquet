package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "usr")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String login;
    @NonNull
    private String password;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @NonNull
    private String phone;
    @NonNull
    private String status;
    @NonNull
    private String about;
}
