package com.app.rest.SpringBootrest.controladores;
import com.app.rest.SpringBootrest.dto.CategoriaDTO;
import com.app.rest.SpringBootrest.entidades.Categoria;
import com.app.rest.SpringBootrest.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> BuscarPorId(@PathVariable Long id){
        Optional<Categoria> categoriaOptional =categoriaServicio.obtenerCategoriaPorId(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .listaDeProductos(categoria.getListaDeProductos())
                    .build();
            return ResponseEntity.ok(categoriaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> buscarTodos(){

        List<CategoriaDTO> categoriaDTOList = categoriaServicio.obtenerTodasLasCategorias().stream().map(categoria -> CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .listaDeProductos(categoria.getListaDeProductos())
                .build())
                .toList();

        return ResponseEntity.ok(categoriaDTOList);

    }

    @PostMapping("/guardar")
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) throws URISyntaxException{
        if (categoriaDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        categoriaServicio.crearCategoria(Categoria.builder().nombre(categoriaDTO.getNombre()).build());

        return ResponseEntity.created(new URI("/api/categoria/guardar")).build();

        /* // Convierte el DTO de Categoria a la entidad Categoria
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setListaDeProductos(categoriaDTO.getListaDeProductos());
        // Llama al servicio para crear la categoría
        categoriaServicio.crearCategoria(categoria);
        return ResponseEntity.created(new URI("/api/categoria/" + categoria.getId())).build();*/
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){

        Optional<Categoria> categoriaOptional = categoriaServicio.obtenerCategoriaPorId(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoria.setNombre(categoriaDTO.getNombre());
            categoriaServicio.crearCategoria(categoria);
            return ResponseEntity.ok("Categoria actualizada");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        if (id != null) {
            categoriaServicio.eliminarCategoria(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id esta vacio");
    }
}
