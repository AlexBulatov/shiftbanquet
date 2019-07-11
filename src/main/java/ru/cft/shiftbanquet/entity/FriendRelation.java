package ru.cft.shiftbanquet.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FriendRelation {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name="subscriber", referencedColumnName = "login")
    private AppUser subscriber;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name="target", referencedColumnName = "login")
    private AppUser target;
}
