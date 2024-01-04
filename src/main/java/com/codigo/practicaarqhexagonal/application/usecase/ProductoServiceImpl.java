package com.codigo.practicaarqhexagonal.application.usecase;

import com.codigo.practicaarqhexagonal.domain.model.Producto;
import com.codigo.practicaarqhexagonal.domain.ports.in.ProductoIn;
import com.codigo.practicaarqhexagonal.domain.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoIn {

    private final ProductoOut productoOut;

    public ProductoServiceImpl(ProductoOut productoOut) {
        this.productoOut = productoOut;

    }

    @Override
    public Producto crearProducto(Producto producto) {
        return this.productoOut.createProducto(producto);
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return this.productoOut.getProducto(id);
    }

    @Override
    public List<Producto> getProductos() {
        return this.productoOut.getProductos();
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return this.productoOut.updateProducto(id,producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return this.productoOut.deleteProducto(id);
    }
}
