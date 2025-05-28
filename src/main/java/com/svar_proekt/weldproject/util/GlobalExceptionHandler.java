package com.svar_proekt.weldproject.util;

import com.svar_proekt.weldproject.dto.ProductionExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductionExceptionDTO> responseEntity(ProductionObjectNotFoundException e) {
        ProductionExceptionDTO productionExceptionDTO = new ProductionExceptionDTO(e.getMessage(), LocalTime.now());
        return new ResponseEntity<>(productionExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
