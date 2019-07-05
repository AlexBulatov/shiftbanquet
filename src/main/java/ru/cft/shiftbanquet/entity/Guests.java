package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
class Guests {

    @Id
    @NonNull
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event_id;

    @NonNull
    private double payed;
    @NonNull
    private double mustPayed;
}
