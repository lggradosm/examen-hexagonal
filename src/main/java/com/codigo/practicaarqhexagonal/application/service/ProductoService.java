package com.codigo.practicaarqhexagonal.application.service;

import com.codigo.practicaarqhexagonal.domain.model.Producto;
import com.codigo.practicaarqhexagonal.domain.ports.in.ProductoIn;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoIn {
    private final ProductoIn productoIn;

    public ProductoService(ProductoIn productoIn) {
        this.productoIn = productoIn;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return this.productoIn.crearProducto(producto);
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return this.productoIn.getProducto(id);
    }

    @Override
    public List<Producto> getProductos() {
        return this.productoIn.getProductos();
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return this.productoIn.actualizarProducto(id,producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return this.productoIn.borrarProducto(id);
    }
}
