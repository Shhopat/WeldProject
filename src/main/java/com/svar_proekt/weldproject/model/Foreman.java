package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "foreman")
public class Foreman {

    public Foreman() {
    }

    public Foreman(int id, String name, String info, ProductionObject productionObject, List<Worker> workerList) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.productionObject = productionObject;
        this.workerList = workerList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)

    private String name;

    @Column(name = "info", length = 200, nullable = false)
    private String info;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProductionObject productionObject;

    @OneToMany(mappedBy = "foreman", fetch = FetchType.EAGER)
    private List<Worker> workerList;

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

    public ProductionObject getProductionObject() {
        return productionObject;
    }

    public void setProductionObject(ProductionObject productionObject) {
        this.productionObject = productionObject;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
