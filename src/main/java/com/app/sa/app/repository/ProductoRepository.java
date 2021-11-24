/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.repository;

import com.app.sa.app.entidad.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DELL
 */
public interface ProductoRepository extends MongoRepository<Producto,String>{
    
}
