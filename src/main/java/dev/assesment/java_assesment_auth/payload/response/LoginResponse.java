package dev.assesment.java_assesment_auth.payload.response;


import lombok.Data;

@Data
public class LoginResponse {


    private String token;

    private Long expiresIn;

}
