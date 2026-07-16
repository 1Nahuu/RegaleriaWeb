package com.regaleria.RegaleriaParis.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.regaleria.RegaleriaParis.domain.Producto;
import com.regaleria.RegaleriaParis.service.ProductServiceInt;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductServiceInt productsService;

    public ProductoController(ProductServiceInt productsService) {
        this.productsService = productsService;
    }


    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Producto> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }



    @PostMapping
    public ResponseEntity<?> postProducto(@Valid @RequestBody Producto prod){
      
        productsService.addProduct(prod);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nombre}")
                .buildAndExpand(prod.getNombre())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    
    @PutMapping
    public ResponseEntity<?> putProducto(@Valid @RequestBody Producto prod){
            return productsService.putProducto(prod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id){
        return productsService.deleteProducto(id);
    }



    @PatchMapping
    public ResponseEntity<?> patchProducto(@RequestBody Producto prod){
        return productsService.patchProducto(prod);
    }


}
