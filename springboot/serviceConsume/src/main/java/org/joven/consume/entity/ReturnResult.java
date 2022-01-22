package org.joven.consume.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ReturnResult<T> {
    int code;
    String message;
    T returnObj;
    String errorMessage;
    T data;
}
