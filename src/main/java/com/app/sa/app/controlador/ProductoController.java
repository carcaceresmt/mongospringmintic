/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sa.app.controlador;

import com.app.sa.app.entidad.Producto;
import com.app.sa.app.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Producto/")  
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")    
    public List<Producto> findAllProducto(){
        return service.getProductos();
    }
    
    @GetMapping("{id}")    
    public Producto findCargosId(@PathVariable String id){
        return service.getProducto(id);
    }   
    
    @GetMapping("/busqueda/{categoria}")    
    public List<Producto> findCategoria(@PathVariable String categoria){
        return service.getCategoriaMarca(categoria);
    }
    
    @GetMapping("/filtro/lte/{precio}")    
    public List<Producto> findCategoria(@PathVariable int precio){
        return service.getProductoPrecioMenor(precio);
    }
    
    @GetMapping("/filtro/entre/{preciomin}/{preciomax}")    
    public List<Producto> findCategoria(@PathVariable int preciomin,
                                        @PathVariable int preciomax){
        return service.getProductoEntrePrecio(preciomin, preciomax);
    }
    
    @PostMapping("/save")
    public ResponseEntity addProducto(@RequestBody Producto producto){
        service.saveProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
     @PutMapping("/save")
       public ResponseEntity updateProducto(@RequestBody Producto product){
       service.updateProducto(product);
       return ResponseEntity.status(201).build();
    }
       
    @DeleteMapping("/{id}")
      public ResponseEntity deleteProducto(@PathVariable String id){
           service.deleteProducto(id);
           return ResponseEntity.status(204).build();
      }
      
      @DeleteMapping("/all")
      public ResponseEntity deleteProductoAll(){
           service.deleteAll();
           return ResponseEntity.status(204).build();
      }
    
}