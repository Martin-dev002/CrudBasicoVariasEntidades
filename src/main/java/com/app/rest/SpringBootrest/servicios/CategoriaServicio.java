package com.app.rest.SpringBootrest.servicios;

import com.app.rest.SpringBootrest.entidades.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaServicio {
    List<Categoria> obtenerTodasLasCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    void crearCategoria(Categoria categoria);

   // void actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
}
