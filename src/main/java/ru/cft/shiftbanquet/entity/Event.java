package ru.cft.shiftbanquet.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Data
@Entity
@Table(name = "events")
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private AppUser author;
    @NonNull
    private String title;
    @NonNull
    private String about;
    @NonNull
    private Long longitude;
    @NonNull
    private Long latitude;
    @NonNull
    private String status;
    @NonNull
    private Date date;


    @OneToMany(mappedBy = "event_id")
    private List<Guests> members;

    @OneToMany(mappedBy = "event_id")
    private List<Expense> expenses;
}
