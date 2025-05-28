package com.svar_proekt.weldproject.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProductionExceptionDTO {
    private String ms;
    private LocalTime localTime;

    public ProductionExceptionDTO() {
    }

    public ProductionExceptionDTO(String ms, LocalTime localTime) {
        this.ms = ms;
        this.localTime = localTime;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}

