package com.app.rest.SpringBootrest.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoria",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Producto> listaDeProductos = new ArrayList<>();
}
