package com.codigo.practicaarqhexagonal.application.service;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import com.codigo.practicaarqhexagonal.domain.ports.in.FacturaCabeceraIn;

import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn{
    private final FacturaCabeceraIn facturaCabeceraIn;

    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn) {
        this.facturaCabeceraIn = facturaCabeceraIn;
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return this.facturaCabeceraIn.crearFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        return this.facturaCabeceraIn.getFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return this.facturaCabeceraIn.actualizarFacturaCabecera(id,facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        return this.facturaCabeceraIn.borrarFacturaCabecera(id);
    }
}
