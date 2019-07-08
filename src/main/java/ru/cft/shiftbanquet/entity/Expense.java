package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "expenses")
@NoArgsConstructor
@RequiredArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NonNull
    private Long event_id;

    @NonNull
    private String name;

    @NonNull
    private Double cost;
}
