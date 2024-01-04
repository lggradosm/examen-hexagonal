package com.codigo.practicaarqhexagonal.infraestructure.repository;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import com.codigo.practicaarqhexagonal.domain.ports.out.FacturaCabeceraOut;
import com.codigo.practicaarqhexagonal.infraestructure.entity.FacturaCabeceraEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FacturaCabeceraJPARepositoryAdapter implements FacturaCabeceraOut {
    @Autowired
    private FacturaCabeceraJPARepository facturaCabeceraJPARepository;


    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        return facturaCabeceraJPARepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        if(facturaCabeceraJPARepository.existsById(id)){
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            return Optional.of(facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        if(facturaCabeceraJPARepository.existsById(id)){
            facturaCabeceraJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
