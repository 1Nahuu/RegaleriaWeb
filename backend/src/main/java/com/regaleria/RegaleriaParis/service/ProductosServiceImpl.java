package com.regaleria.RegaleriaParis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.regaleria.RegaleriaParis.domain.Producto;

@Service
public class ProductosServiceImpl implements ProductServiceInt {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductosServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getProducts() {
        return productoRepository.findAll();
    }

    @Override
    public void addProduct(Producto product) {
        product.setId(null);
        productoRepository.save(product);
    }

    @Override
    public ResponseEntity<?> putProducto(Producto prod) {
        Optional<Producto> existente = productoRepository.findById(prod.getId());
        if (existente.isPresent()) {
            Producto p = existente.get();
            p.setNombre(prod.getNombre());
            p.setPrecio(prod.getPrecio());
            p.setCantidad(prod.getCantidad());
            productoRepository.save(p);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> deleteProducto(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> patchProducto(Producto prod) {
        Optional<Producto> existente = productoRepository.findById(prod.getId());
        if (existente.isPresent()) {
            Producto p = existente.get();
            if (prod.getNombre() != null) {
                p.setNombre(prod.getNombre());
            }
            if (prod.getPrecio() != null) {
                p.setPrecio(prod.getPrecio());
            }
            if (prod.getCantidad() != null) {
                p.setCantidad(prod.getCantidad());
            }
            productoRepository.save(p);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}