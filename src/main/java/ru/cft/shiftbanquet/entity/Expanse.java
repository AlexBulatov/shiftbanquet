package ru.cft.shiftbanquet.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "expanses")
@NoArgsConstructor
@RequiredArgsConstructor
public class Expanse {

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
