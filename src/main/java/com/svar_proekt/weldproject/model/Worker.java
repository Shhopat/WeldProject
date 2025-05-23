package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {

    public Worker() {
    }

    public Worker(int id, String name, String position, Foreman foreman) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.foreman = foreman;
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
    private Foreman foreman;

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

    public Foreman getForeman() {
        return foreman;
    }

    public void setForeman(Foreman foreman) {
        this.foreman = foreman;
    }
}
