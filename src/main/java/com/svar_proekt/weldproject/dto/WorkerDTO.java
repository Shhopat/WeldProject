package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Position;
import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class WorkerDTO {
    public WorkerDTO() {
    }

    public WorkerDTO(int id, String name, Position position, ForemanDTO foremanDTO) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.foremanDTO = foremanDTO;
    }

    public String getPositionString() {
        return this.position.getDisplayName();
    }


    private int id;

    @NotEmpty(message = "name not be empty")
    @Size(min = 4, max = 40, message = "name should be between 4-40")
    private String name;


    private Position position;


    private ForemanDTO foremanDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ForemanDTO getForemanDTO() {
        return foremanDTO;
    }

    public void setForemanDTO(ForemanDTO foremanDTO) {
        this.foremanDTO = foremanDTO;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", foremanDTO=" + foremanDTO +
                '}';
    }
}
