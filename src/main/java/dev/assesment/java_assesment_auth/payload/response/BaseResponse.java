package dev.assesment.java_assesment_auth.payload.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse <T>{

    private boolean succes;

    private String message;


    private T data;

}
