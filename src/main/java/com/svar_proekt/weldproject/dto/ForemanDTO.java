package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.model.Worker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ForemanDTO {
    public ForemanDTO() {
    }

    public ForemanDTO(int id, String name, String info, ProductionObjectDTO productionObjectDTO, List<WorkerDTO> workerDTOList) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.productionObjectDTO = productionObjectDTO;
        this.workerDTOList = workerDTOList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    @Size(message = "name should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "name not be empty")
    private String name;

    @Column(name = "info", length = 200, nullable = false)
    private String info;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProductionObjectDTO productionObjectDTO;

    @OneToMany(mappedBy = "foremanDTO", fetch = FetchType.EAGER)
    private List<WorkerDTO> workerDTOList;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ProductionObjectDTO getProductionObjectDTO() {
        return productionObjectDTO;
    }

    public void setProductionObjectDTO(ProductionObjectDTO productionObjectDTO) {
        this.productionObjectDTO = productionObjectDTO;
    }

    public List<WorkerDTO> getWorkerDTOList() {
        return workerDTOList;
    }

    public void setWorkerDTOList(List<WorkerDTO> workerDTOList) {
        this.workerDTOList = workerDTOList;
    }
}
