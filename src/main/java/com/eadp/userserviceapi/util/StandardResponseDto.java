package com.eadp.userserviceapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDto {
    private String message;
    private int code;
    private Object data;
}
