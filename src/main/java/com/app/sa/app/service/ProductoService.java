/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.service;

import com.app.sa.app.entidad.Producto;
import com.app.sa.app.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    public List<Producto> getProductos(){
        return repository.findAll();
    }
    
    public Producto saveProducto(Producto producto){
        return repository.save(producto);
    }
    
    public Producto getProducto(String id){
        return repository.findById(id).orElse(null);
    }
    
    public Producto updateProducto(Producto producto){
        
       Producto existeProducto=getProducto(producto.getId());
       existeProducto.setCodigo(producto.getCodigo());
       existeProducto.setCategoria(producto.getCategoria());
       existeProducto.setDescripcion(producto.getDescripcion());
       existeProducto.setPrecio(producto.getPrecio());
       existeProducto.setDisponibilidad(producto.isDisponibilidad());
       existeProducto.setStock(producto.getStock());
       existeProducto.setRuta(producto.getRuta());
       return repository.save(existeProducto);
    }
    
    public void deleteProducto(String id){
        repository.deleteById(id);
       
    }      
}
