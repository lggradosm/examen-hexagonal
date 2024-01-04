package com.codigo.practicaarqhexagonal.infraestructure.controller;

import com.codigo.practicaarqhexagonal.application.service.ProductoService;
import com.codigo.practicaarqhexagonal.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos(){
        return new ResponseEntity<>(productoService.getProductos(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> create (@RequestBody Producto producto){
        Producto createProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(createProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long productoId){
        return productoService.getProducto(productoId)
                .map(producto -> new ResponseEntity<>(producto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{productoId}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long productoId, @RequestBody Producto producto){
        return productoService.actualizarProducto(productoId,producto)
                .map(p-> new ResponseEntity<>(p,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProductoById (@PathVariable Long productoId){
        if(productoService.borrarProducto(productoId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
