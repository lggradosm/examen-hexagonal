package com.codigo.practicaarqhexagonal.domain.ports.out;

import com.codigo.practicaarqhexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoOut {
    Producto createProducto(Producto producto);
    List<Producto> getProductos();
    Optional<Producto> getProducto(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    boolean deleteProducto (Long id);
}
