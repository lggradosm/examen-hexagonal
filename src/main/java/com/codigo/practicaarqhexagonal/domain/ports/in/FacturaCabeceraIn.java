package com.codigo.practicaarqhexagonal.domain.ports.in;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import com.codigo.practicaarqhexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraIn {
    FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> getFacturaCabecera(Long id);
    Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean borrarFacturaCabecera(Long id);
}
