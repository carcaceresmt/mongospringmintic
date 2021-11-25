/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.repository;

import com.app.sa.app.entidad.Producto;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DELL
 */
public interface ProductoRepository extends MongoRepository<Producto,String>{
    
    @Query("{categoria:?0}")
    List<Producto> getProductoMarca(String categoria);
    @Query("{precio:{$lte:?0}}")
    List<Producto> getProductoPrecioMenor(int precio); 
    @Query("{precio:{$gte:?0,$lte:?1}}")
    List<Producto> getProductoEntrePrecio(int preciomin,int preciomax);
    
    
}
