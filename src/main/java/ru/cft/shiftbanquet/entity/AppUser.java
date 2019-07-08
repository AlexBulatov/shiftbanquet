package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
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

    /*@OneToMany(mappedBy = "author")
    private List<Event> eventList;*/

}
