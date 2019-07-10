package ru.cft.shiftbanquet.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/*@Getter
@Data
@AllArgsConstructor*/
public class Wrapper<T> {

    String status;

    T data;

    @JsonCreator
    public Wrapper(@JsonProperty("data") T data) {
        this.data = data;
    }

    public Wrapper(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
