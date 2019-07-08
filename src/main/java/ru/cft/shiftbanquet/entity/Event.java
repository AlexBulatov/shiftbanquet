package ru.cft.shiftbanquet.entity;


import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "events")
@NoArgsConstructor
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

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

    //TODO expanse @Formula
    @Formula("select sum(e.cost) from expanses e where e.event_id = id")
    private Double totalCost;
}
