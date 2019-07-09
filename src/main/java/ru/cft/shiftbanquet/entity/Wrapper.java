package ru.cft.shiftbanquet.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wrapper<T> {

    String status;

    T data;

    @JsonCreator
    public Wrapper(@JsonProperty("data") T data) {
        this.data = data;
    }
}
