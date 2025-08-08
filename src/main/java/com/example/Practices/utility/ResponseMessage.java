package com.example.Practices.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseMessage<T> {
    private T Data;
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
