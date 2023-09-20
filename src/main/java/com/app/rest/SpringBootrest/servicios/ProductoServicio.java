package com.app.rest.SpringBootrest.servicios;

import com.app.rest.SpringBootrest.entidades.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoPorId(Long id);
    void crearProducto(Producto producto);

    List<Producto> buscarPrecioEnRango(BigDecimal precioMin,BigDecimal precioMAX);

  //  void actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}
