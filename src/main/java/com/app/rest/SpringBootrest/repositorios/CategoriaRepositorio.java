package com.app.rest.SpringBootrest.repositorios;

import com.app.rest.SpringBootrest.entidades.Categoria;
import com.app.rest.SpringBootrest.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
