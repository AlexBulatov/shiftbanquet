package ru.cft.shiftbanquet.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
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
    private Double longitude;
    @NonNull
    private Double latitude;

    private String status;
    @NonNull
    private Date date;

    public Event(AppUser appUser, String title, String about, Double longitude, Double latitude, Date date) {
        this.author = appUser;
        this.title = title;
        this.about = about;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    @OneToMany(mappedBy = "event_id")
    private List<Guests> members;

    @OneToMany(mappedBy = "event_id")
    private List<Expense> expenses;
}
