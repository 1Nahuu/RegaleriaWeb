package com.regaleria.RegaleriaParis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.regaleria.RegaleriaParis.domain.Producto;


@Service
public class ProductosServiceImpl implements ProductServiceInt{

     private List<Producto> products = new ArrayList<>(Arrays.asList(
            new Producto(1,1,799.99,"laptop"),
            new Producto(2,25,499.99,"Smarthphone"),
            new Producto(3,15,299.99,"Tablet"),
            new Producto(4,30,199.99,"SmarthWatch")
    ));

    private final AtomicInteger idCounter = new AtomicInteger(products.stream()
        .mapToInt(Producto::getId)
        .max()
        .orElse(0));

    @Override
    public List<Producto> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Producto product) {
        product.setId(idCounter.getAndIncrement());
        products.add(product);
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }

    @Override
    public ResponseEntity<?> putProducto(Producto prod){
        for(Producto p:products){
            if(Objects.equals(p.getId(), prod.getId())){
                p.setNombre(prod.getNombre());
                p.setPrecio(prod.getPrecio());
                p.setCantidad(prod.getCantidad());
                return ResponseEntity.noContent().build();
            }
        }
       return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> deleteProducto(int id){
        for(Producto p:products){
            if(Objects.equals(p.getId(), id)){
                products.remove(p);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> patchProducto(Producto prod){
        for(Producto p:products){
            if(Objects.equals(p.getId(), prod.getId())){
                if(prod.getNombre() != null){
                    p.setNombre(prod.getNombre());
                }
                if(prod.getPrecio() != null){
                    p.setPrecio(prod.getPrecio());
                }
                if(prod.getCantidad() != null){
                    p.setCantidad(prod.getCantidad());
                }
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}
