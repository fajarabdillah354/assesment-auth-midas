package dev.assesment.java_assesment_auth.payload.request;


import lombok.Data;

@Data
public class LoginRequest {

    private String email;


    private String password;


}
