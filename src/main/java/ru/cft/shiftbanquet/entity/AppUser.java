package ru.cft.shiftbanquet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    // One to Many -- ?

   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "subscriber")
    @JsonIgnore
    private List<FriendRelation> targets;*/

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "target")
    @JsonIgnore
    private List<FriendRelation> subscribers;*/

    //@OneToMany(mappedBy = "author")
    //private List<Event> events;

}
