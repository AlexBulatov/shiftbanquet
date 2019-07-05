package ru.cft.shiftbanquet.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Wrapper<T> {
    @NonNull
    String status;

    T data;
}
