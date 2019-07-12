package ru.cft.shiftbanquet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.cft.shiftbanquet.payloads.ExpenseRequestPostPayload;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expenses")
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NonNull
    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @NonNull
    private String name;

    @NonNull
    private Double cost;


}
