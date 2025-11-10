package com.regaleria.RegaleriaParis.domain;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer cantidad;


    public Producto() {
    }

    public Producto(Integer id, Integer cantidad, Double precio, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
