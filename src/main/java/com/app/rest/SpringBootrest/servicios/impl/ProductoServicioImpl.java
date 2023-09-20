package com.app.rest.SpringBootrest.servicios.impl;

import com.app.rest.SpringBootrest.entidades.Producto;
import com.app.rest.SpringBootrest.repositorios.CategoriaRepositorio;
import com.app.rest.SpringBootrest.repositorios.ProductoRepositorio;
import com.app.rest.SpringBootrest.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service

public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    CategoriaRepositorio categoriaRepositorio;


    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepositorio.findById(id);
    }


    @Override
    public void crearProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public List<Producto> buscarPrecioEnRango(BigDecimal precioMin, BigDecimal precioMAX) {
        return productoRepositorio.buscarProductoPorRangoDePrecio(precioMin,precioMAX);
    }



    @Override
    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
