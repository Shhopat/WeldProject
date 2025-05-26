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


    private int id;


    @NotEmpty(message = "name not be empty")
    @Size(message = "name should be between 3 - 40",min = 3, max = 40)
    private String name;


    @NotEmpty(message = "info not be empty")
    @Size(message = "info should be between 3 - 40",min = 3, max = 200)
    private String info;



    private ProductionObjectDTO productionObjectDTO;


    private List<WorkerDTO> workerDTOList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("foremanDTO setId вызвался. присваивается  " + id );
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

    @Override
    public String toString() {
        return "ForemanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", productionObjectDTO=" + productionObjectDTO +
                ", workerDTOList=" + workerDTOList +
                '}';
    }
}
