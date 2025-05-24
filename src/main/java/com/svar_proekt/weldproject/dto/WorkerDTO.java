package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;

public class WorkerDTO {
    public WorkerDTO() {
    }

    public WorkerDTO(int id, String name, String position, ForemanDTO foremanDTO) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.foremanDTO = foremanDTO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "position", length = 40, nullable = false)
    private String position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foreman_id", referencedColumnName = "id")
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ForemanDTO getForemanDTO() {
        return foremanDTO;
    }

    public void setForemanDTO(ForemanDTO foremanDTO) {
        this.foremanDTO = foremanDTO;
    }
}
