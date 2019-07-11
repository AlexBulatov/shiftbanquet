package ru.cft.shiftbanquet.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.cft.shiftbanquet.entity.Event;

import java.util.Date;

@Data
@NoArgsConstructor
public class EventResponseGetPayload {

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
    @NonNull
    private Double totalCost;

    public EventResponseGetPayload(Event event){
        this.title = event.getTitle();
        this.about = event.getAbout();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
        this.date = event.getDate();
        this.totalCost = event.getTotalCost();
    }
}

