package com.codigo.practicaarqhexagonal.domain.ports.in;

import com.codigo.practicaarqhexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
    Producto crearProducto(Producto producto);
    Optional<Producto> getProducto(Long id);
    List<Producto> getProductos();
    Optional<Producto> actualizarProducto(Long id, Producto producto);
    boolean borrarProducto(Long id);
}
