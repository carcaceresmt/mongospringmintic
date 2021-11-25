/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DELL
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "producto")
public class Producto {
    @Id
    private String id;
    private String nomprod;
    private int precio;
    private String categoria;
    private int stock;
    private String descripcion;       
    
}
