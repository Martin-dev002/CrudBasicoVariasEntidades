package com.app.rest.SpringBootrest.controladores;

import com.app.rest.SpringBootrest.dto.ProductoDTO;
import com.app.rest.SpringBootrest.entidades.Producto;
import com.app.rest.SpringBootrest.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/buscar/{id}")
    private ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoServicio.obtenerProductoPorId(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .categoria(producto.getCategoria())
                    .build();
            return ResponseEntity.ok(productoDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/buscarTodos")
    private ResponseEntity<?> buscarTodos() {
        List<ProductoDTO> productoDTOList = productoServicio.obtenerTodosLosProductos()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .categoria(producto.getCategoria())
                        .build())
                .toList();
        return ResponseEntity.ok(productoDTOList);
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if (productoDTO.getNombre().isBlank() || productoDTO.getPrecio()==null || productoDTO.getCategoria() == null) {
            return ResponseEntity.badRequest().build();
        }
        Producto producto = Producto.builder()
                .id(productoDTO.getId())
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .categoria(productoDTO.getCategoria())
                .build();

        productoServicio.crearProducto(producto);
        return ResponseEntity.created(new URI("/api/producto/guardar")).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarProduct(@PathVariable Long id, @RequestBody ProductoDTO producOtDTO){
        Optional<Producto> productoOptional = productoServicio.obtenerProductoPorId(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(producOtDTO.getNombre());
            producto.setPrecio(producto.getPrecio());
            producto.setCategoria(producOtDTO.getCategoria());
            productoServicio.crearProducto(producto);
            return ResponseEntity.ok("Producto actulizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id !=null) {
            productoServicio.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id esta vacio");
    }
}
