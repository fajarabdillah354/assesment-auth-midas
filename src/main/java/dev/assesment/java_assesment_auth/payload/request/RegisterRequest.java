package dev.assesment.java_assesment_auth.payload.request;


import lombok.Data;

@Data
public class RegisterRequest {

    private String fullname;

    private String password;

    private String email;

}
