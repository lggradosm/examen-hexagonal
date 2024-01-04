package com.codigo.practicaarqhexagonal.domain.ports.out;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;

import java.util.Optional;

public interface FacturaCabeceraOut {
    FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> getFacturaCabecera(Long id);
    Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean borrarFacturaCabecera(Long id);
}
