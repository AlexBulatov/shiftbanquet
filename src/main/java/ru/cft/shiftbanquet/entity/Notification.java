package ru.cft.shiftbanquet.entity;

import lombok.*;
import ru.cft.shiftbanquet.entity.entityType.NotificationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long user_to;

    @NonNull
    private Long user_from;

    @NonNull
    private NotificationType type;
}
