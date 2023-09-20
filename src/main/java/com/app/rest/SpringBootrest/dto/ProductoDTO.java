package com.app.rest.SpringBootrest.dto;

import com.app.rest.SpringBootrest.entidades.Categoria;
import lombok.*;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Categoria categoria;

}
