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
    private Event eventId;

    @NonNull
    private double paid;
    @NonNull
    private double mustPay;

    public Guest(AppUser user, double payed, double mustPayed){
        this.user = user;
        this.paid = payed;
        this.mustPay = mustPayed;
    }

    public Guest(AppUser user, Event event) {
        this.user = user;
        this.eventId = event;
        this.paid = 0;
        this.mustPay = 0;
    }

    public Guest(AppUser user, Event event, double payed, double mustPayed){
        this.user = user;
        this.eventId  = event;
        this.paid = payed;
        this.mustPay = mustPayed;
    }

    public void setGuest(Guest newGuest) {
        this.paid = newGuest.getPaid();
        this.mustPay = newGuest.getMustPay();
    }
}
