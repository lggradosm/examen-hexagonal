package com.codigo.practicaarqhexagonal.infraestructure.repository;

import com.codigo.practicaarqhexagonal.infraestructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoJPARepository extends JpaRepository<ProductoEntity,Long> {
}
