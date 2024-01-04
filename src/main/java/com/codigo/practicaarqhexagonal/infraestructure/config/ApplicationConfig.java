package com.codigo.practicaarqhexagonal.infraestructure.config;

import com.codigo.practicaarqhexagonal.application.service.FacturaCabeceraService;
import com.codigo.practicaarqhexagonal.application.service.ProductoService;
import com.codigo.practicaarqhexagonal.application.usecase.FacturaCabeceraImpl;
import com.codigo.practicaarqhexagonal.application.usecase.ProductoServiceImpl;
import com.codigo.practicaarqhexagonal.domain.ports.out.FacturaCabeceraOut;
import com.codigo.practicaarqhexagonal.domain.ports.out.ProductoOut;
import com.codigo.practicaarqhexagonal.infraestructure.repository.FacturaCabeceraJPARepositoryAdapter;
import com.codigo.practicaarqhexagonal.infraestructure.repository.ProductoJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProductoService productoService(ProductoOut productoOut){
        return new ProductoService(new ProductoServiceImpl(productoOut));
    }
    @Bean
    public ProductoOut productoOut (ProductoJPARepositoryAdapter productoJPARepositoryAdapter){
        return productoJPARepositoryAdapter;
    }
    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOut facturaCabeceraOut){
        return new FacturaCabeceraService(new FacturaCabeceraImpl(facturaCabeceraOut));
    }
    @Bean
    public FacturaCabeceraOut facturaCabeceraOut(FacturaCabeceraJPARepositoryAdapter facturaCabeceraJPARepositoryAdapter){
        return facturaCabeceraJPARepositoryAdapter;
    }
}
