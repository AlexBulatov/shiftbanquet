package ru.cft.shiftbanquet.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FriendPK implements Serializable {
    private AppUser subscriber;

    private AppUser target;
}

