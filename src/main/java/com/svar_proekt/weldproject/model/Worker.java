package com.svar_proekt.weldproject.model;

import com.svar_proekt.weldproject.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "worker")

@Getter
@Setter //пишем вместо Date
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    @NotEmpty(message = "name not be empty")
    @Size(min = 4, max = 40, message = "name should be between 4-40")
    private String name;

    @Column(name = "position", length = 40, nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foreman_id", referencedColumnName = "id")
    private Foreman foreman;


}
