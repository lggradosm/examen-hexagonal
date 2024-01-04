package com.codigo.practicaarqhexagonal.infraestructure.entity;

import com.codigo.practicaarqhexagonal.domain.model.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;

    public static ProductoEntity fromDomainModel(Producto producto){
        return new ProductoEntity(producto.getId(), producto.getNombre(), producto.getDescripcion(),producto.getPrecio(),producto.getStock());
    }

    public Producto toDomainModel (){
        return new Producto(this.getId(), this.getNombre(), this.getDescripcion(), this.getPrecio(), this.getStock());
    }

}
