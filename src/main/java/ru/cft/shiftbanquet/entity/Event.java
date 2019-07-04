package ru.cft.shiftbanquet.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "events")
@NoArgsConstructor
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    @NonNull
    private EventType type;
    @NonNull
    private String title;
    @NonNull
    private String about;
    @NonNull
    private String tags;

    @NonNull
    private String place;
    @NonNull
    private String status;
    @NonNull
    private Date date;

}
