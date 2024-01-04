package com.codigo.practicaarqhexagonal.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FacturaDetalle")
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalle_id;
    @OneToOne
    @JoinTable(name = "factura_id")
    private FacturaCabeceraEntity facturaCabecera;
    @ManyToOne
    @JoinTable(
            name = "producto_id"
    )
    private ProductoEntity producto;
    private int cantidad;
    private Double precio_unitario;
    private Double subtotal;
}
