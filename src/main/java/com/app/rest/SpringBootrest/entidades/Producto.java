package com.app.rest.SpringBootrest.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnore
    private Categoria categoria;


}