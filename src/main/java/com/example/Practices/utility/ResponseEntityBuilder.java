package com.example.Practices.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static <T> ResponseEntity<ResponseMessage<T>> success(T data, String message, int statuscode,
            LocalDateTime timestamp) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage<>(data, message, statuscode, timestamp));
    }

    public static <T> ResponseEntity<ResponseMessage<T>> notFound(String message, int statuscode,
            LocalDateTime timestamp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseMessage<>(null, message, statuscode, timestamp));
    }
    public static <T>ResponseEntity<ResponseMessage<T>> serverError(String message,int statuscode,LocalDateTime timestamp){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage<>(null,message,statuscode,timestamp));
    }
    public static <T>ResponseEntity<ResponseMessage<T>> checkDuplicateMessage(String message,int statusCode,LocalDateTime timestamp){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage<>(null,message,statusCode,timestamp));
    }
}
