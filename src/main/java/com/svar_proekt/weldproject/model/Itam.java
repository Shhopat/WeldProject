package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itam")
public class Itam {
    public Itam() {
    }

    public Itam(int id, String name, ProductionObject productionObject) {
        this.id = id;
        this.name = name;
        this.productionObject = productionObject;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProductionObject productionObject;

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

    public ProductionObject getProductionObject() {
        return productionObject;
    }

    public void setProductionObject(ProductionObject productionObject) {
        this.productionObject = productionObject;
    }
}
