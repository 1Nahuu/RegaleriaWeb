package com.regaleria.RegaleriaParis.domain;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class Producto {
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;


    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    @PositiveOrZero(message = "La cantidad no puede ser negativa")
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
