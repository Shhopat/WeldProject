package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "foreman")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Foreman {
    public Foreman(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    @NotEmpty(message = "name not be empty")
    @Size(message = "name should be between 3 - 40",min = 3, max = 40)
    private String name;

    @Column(name = "info", length = 200, nullable = false)
    @NotEmpty(message = "info not be empty")
    @Size(message = "info should be between 3 - 40",min = 3, max = 200)
    private String info;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProductionObject productionObject;

    @OneToMany(mappedBy = "foreman", fetch = FetchType.EAGER)
    private List<Worker> workerList;


}
