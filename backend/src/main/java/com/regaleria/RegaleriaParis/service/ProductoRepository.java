package com.regaleria.RegaleriaParis.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regaleria.RegaleriaParis.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}