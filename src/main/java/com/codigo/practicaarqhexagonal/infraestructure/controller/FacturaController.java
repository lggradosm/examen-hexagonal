package com.codigo.practicaarqhexagonal.infraestructure.controller;

import com.codigo.practicaarqhexagonal.application.service.FacturaCabeceraService;
import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }

    @PostMapping
    public ResponseEntity<FacturaCabecera> create (@RequestBody FacturaCabecera facturaCabecera){
        FacturaCabecera createFacturaCabecera = facturaCabeceraService.crearFacturaCabecera(facturaCabecera);
        return new ResponseEntity<>(createFacturaCabecera, HttpStatus.CREATED);
    }

    @GetMapping("/{facturaCabeceraId}")
    public ResponseEntity<FacturaCabecera> getProductoById(@PathVariable Long facturaCabeceraId){
        return facturaCabeceraService.getFacturaCabecera(facturaCabeceraId)
                .map(facturaCabecera -> new ResponseEntity<>(facturaCabecera,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{facturaCabeceraId}")
    public ResponseEntity<FacturaCabecera> updateProducto(@PathVariable Long facturaCabeceraId, @RequestBody FacturaCabecera facturaCabecera){
        return facturaCabeceraService.actualizarFacturaCabecera(facturaCabeceraId,facturaCabecera)
                .map(p-> new ResponseEntity<>(p,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{facturaCabeceraId}")
    public ResponseEntity<Void> deleteProductoById (@PathVariable Long facturaCabeceraId){
        if(facturaCabeceraService.borrarFacturaCabecera(facturaCabeceraId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
