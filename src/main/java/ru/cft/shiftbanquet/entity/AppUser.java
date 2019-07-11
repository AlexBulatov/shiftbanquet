package ru.cft.shiftbanquet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

    // One to Many -- ?

    @OneToMany(mappedBy = "subscriber")
    private List<FriendRelation> targets;

    @OneToMany(mappedBy = "target")
    private List<FriendRelation> subscribers;

    @OneToMany(mappedBy = "author")
    private List<Event> events;

}
