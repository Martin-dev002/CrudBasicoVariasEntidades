package com.app.rest.SpringBootrest.servicios.impl;

import com.app.rest.SpringBootrest.entidades.Categoria;
import com.app.rest.SpringBootrest.repositorios.CategoriaRepositorio;
import com.app.rest.SpringBootrest.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepositorio.findById(id);
    }


    @Override
    public void crearCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    /*@Override
    public void actualizarCategoria(Long id, Categoria categoria) {

    }*/

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}
