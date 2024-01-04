package com.codigo.practicaarqhexagonal.application.usecase;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import com.codigo.practicaarqhexagonal.domain.ports.in.FacturaCabeceraIn;
import com.codigo.practicaarqhexagonal.domain.ports.out.FacturaCabeceraOut;

import java.util.Optional;

public class FacturaCabeceraImpl implements FacturaCabeceraIn {
    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraImpl(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return this.facturaCabeceraOut.crearFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        return this.facturaCabeceraOut.getFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return this.facturaCabeceraOut.actualizarFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        return this.facturaCabeceraOut.borrarFacturaCabecera(id);
    }
}
