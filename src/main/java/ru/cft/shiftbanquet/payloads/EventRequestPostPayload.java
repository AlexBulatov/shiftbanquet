package ru.cft.shiftbanquet.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class EventRequestPostPayload {

    @NonNull
    private String title;
    @NonNull
    private String about;
    @NonNull
    private Double longitude;
    @NonNull
    private Double latitude;
    @NonNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

}
