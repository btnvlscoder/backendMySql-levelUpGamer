package com.example.ventaapp.service;

import com.example.ventaapp.dto.VentaDTO;
import com.example.ventaapp.model.Venta;

import java.util.List;

public interface VentaService {
    Venta crearVenta(VentaDTO ventaDTO);
    List<Venta> obtenerVentas();
    void eliminarVenta(Long id);
}