package com.app.rest.SpringBootrest.repositorios;

import com.app.rest.SpringBootrest.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")
    List<Producto> buscarProductoPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax);

    //List<Producto> buscarProductoPorPrecioEntreB(BigDecimal precioMin, BigDecimal precioMax);
}
