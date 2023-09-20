package com.app.rest.SpringBootrest.dto;

import com.app.rest.SpringBootrest.entidades.Producto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private List<Producto> listaDeProductos = new ArrayList<>();

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }
}
