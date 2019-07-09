package ru.cft.shiftbanquet.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.cft.shiftbanquet.entity.entityStatus.EventStatus;

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

    private EventStatus status;
    @NonNull
    private Date date;

    public Event(AppUser appUser, String title, String about, Double longitude, Double latitude, Date date) {
        this.author = appUser;
        this.title = title;
        this.about = about;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
        this.status = EventStatus.ORGANIZING;
    }

    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "event_id")
    private List<Guest> members;

    @OneToMany(mappedBy = "event_id")
    private List<Expense> expenses;
}
