package com.codigo.practicaarqhexagonal.infraestructure.repository;

import com.codigo.practicaarqhexagonal.domain.model.Producto;
import com.codigo.practicaarqhexagonal.domain.ports.out.ProductoOut;
import com.codigo.practicaarqhexagonal.infraestructure.entity.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ProductoJPARepositoryAdapter implements ProductoOut {
    @Autowired
    private ProductoJPARepository productoJPARepository;
    @Override
    public Producto createProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJPARepository.save(productoEntity).toDomainModel();
    }

    @Override
    public List<Producto> getProductos() {
        return productoJPARepository.findAll().stream().map(ProductoEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return productoJPARepository.findById(id).map(ProductoEntity::toDomainModel);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        if(productoJPARepository.existsById(id)){
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            return Optional.of(productoJPARepository.save(productoEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteProducto(Long id) {
        if(productoJPARepository.existsById(id)){
            productoJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
