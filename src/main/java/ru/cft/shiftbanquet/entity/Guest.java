package ru.cft.shiftbanquet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @NonNull
    @ManyToOne(targetEntity = Event.class)
    @JoinColumn(name = "event_id")
    private Event event_id;

    @NonNull
    private double payed;
    @NonNull
    private double mustPayed;

    public Guest(AppUser user, double payed, double mustPayed){
        this.user = user;
        this.payed = payed;
        this.mustPayed = mustPayed;
    }

    public Guest(AppUser user, Event event, double payed, double mustPayed){
        this.user = user;
        this.event_id = event;
        this.payed = payed;
        this.mustPayed = mustPayed;
    }

}
