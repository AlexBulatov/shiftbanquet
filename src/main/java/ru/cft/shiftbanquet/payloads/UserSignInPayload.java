package ru.cft.shiftbanquet.payloads;


import lombok.*;

@Data
public class UserSignInPayload {
    @NonNull
    private String login;
    @NonNull
    private String password;
}
