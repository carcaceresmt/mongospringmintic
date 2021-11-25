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
       existeProducto.setId(producto.getId());
       existeProducto.setNomprod(producto.getNomprod());
       existeProducto.setPrecio(producto.getPrecio());
       existeProducto.setCategoria(producto.getCategoria());
        existeProducto.setStock(producto.getStock());
       existeProducto.setDescripcion(producto.getDescripcion());
       
       return repository.save(existeProducto);
    }
    
    public void deleteProducto(String id){
        repository.deleteById(id);
       
    }    
    
    public void deleteAll(){
        repository.deleteAll();
    }
    
    public List<Producto> getCategoriaMarca(String categoria){
        return repository.getProductoMarca(categoria);
    }
    public List<Producto> getProductoPrecioMenor(int precio){
        return repository.getProductoPrecioMenor(precio);
    }
    
    public List<Producto> getProductoEntrePrecio(int preciomin,int preciomax){
        return repository.getProductoEntrePrecio(preciomin, preciomax);
    }
    
}
