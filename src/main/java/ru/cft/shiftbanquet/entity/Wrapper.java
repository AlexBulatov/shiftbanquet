package ru.cft.shiftbanquet.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*@Getter
@Data
@AllArgsConstructor*/
public class Wrapper<T> {

    String req;

    T data;

    @JsonCreator
    public Wrapper(@JsonProperty("data") T data) {
        this.data = data;
    }

    public Wrapper(String req, T data) {
        this.req = req;
        this.data = data;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
