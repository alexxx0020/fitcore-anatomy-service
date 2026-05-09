package com.longo.anatomy_service.error;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private LocalDateTime localDateTime;
    private int status;
    private String message;
    private String path;

}
