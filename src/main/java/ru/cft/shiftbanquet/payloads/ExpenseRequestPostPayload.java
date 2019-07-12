package ru.cft.shiftbanquet.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.cft.shiftbanquet.entity.Event;

@Data
@NoArgsConstructor
public class ExpenseRequestPostPayload {

    @NonNull
    private String name;

    @NonNull
    private Double cost;
}
