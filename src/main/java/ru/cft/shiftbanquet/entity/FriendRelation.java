package ru.cft.shiftbanquet.entity;

import javax.persistence.*;

@Entity
public class FriendRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name="subscriber")
    private AppUser subscriber;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name="target")
    private AppUser target;
}
