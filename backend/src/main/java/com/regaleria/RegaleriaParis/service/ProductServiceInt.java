package com.regaleria.RegaleriaParis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.regaleria.RegaleriaParis.domain.Producto;

public interface ProductServiceInt {

        
     List<Producto> getProducts();

    public void addProduct(Producto prod);

    public ResponseEntity<?> putProducto(Producto prod);

    public ResponseEntity<?> deleteProducto(int id);

    public ResponseEntity<?> patchProducto(Producto prod);



}
