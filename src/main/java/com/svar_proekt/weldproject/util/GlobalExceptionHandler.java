package com.svar_proekt.weldproject.util;

import com.svar_proekt.weldproject.dto.ProductionExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductionExceptionDTO> responseEntity(ProductionObjectNotFoundException e) {
        ProductionExceptionDTO productionExceptionDTO = new ProductionExceptionDTO(e.getMessage(), LocalTime.now());
        log.debug("перехватил исключение " );
        return new ResponseEntity<>(productionExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
