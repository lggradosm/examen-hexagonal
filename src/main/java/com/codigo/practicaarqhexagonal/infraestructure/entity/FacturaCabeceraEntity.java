package com.codigo.practicaarqhexagonal.infraestructure.entity;

import com.codigo.practicaarqhexagonal.domain.model.FacturaCabecera;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FacturaCabecera")
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="factura_id")
    private Long id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Double total;

    public static FacturaCabeceraEntity fromDomainModel (FacturaCabecera facturaCabecera){
        return new FacturaCabeceraEntity(facturaCabecera.getId(),facturaCabecera.getCliente_nombre(),facturaCabecera.getCliente_num_documento(),facturaCabecera.getFecha_emision(),facturaCabecera.getTotal());
    }

    public FacturaCabecera toDomainModel() {
        return new FacturaCabecera(this.getId(),this.getCliente_nombre(),this.getCliente_num_documento(),this.getFecha_emision(),this.getTotal());
    }
}
