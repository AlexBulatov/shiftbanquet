package ru.cft.shiftbanquet.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSignInPayload {
    @NonNull
    private String login;
    @NonNull
    private String password;
}
