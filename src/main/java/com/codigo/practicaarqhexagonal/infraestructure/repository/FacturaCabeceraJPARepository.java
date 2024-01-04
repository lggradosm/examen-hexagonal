package com.codigo.practicaarqhexagonal.infraestructure.repository;


import com.codigo.practicaarqhexagonal.infraestructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCabeceraJPARepository extends JpaRepository<FacturaCabeceraEntity,Long> {
}
