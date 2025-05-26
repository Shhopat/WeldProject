package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Position;
import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;

public class WorkerDTO {
    public WorkerDTO() {
    }

    public WorkerDTO(int id, String name, Position position, ForemanDTO foremanDTO) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.foremanDTO = foremanDTO;
    }


    private int id;


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
