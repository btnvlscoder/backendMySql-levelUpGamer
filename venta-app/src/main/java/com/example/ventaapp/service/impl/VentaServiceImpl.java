package com.example.ventaapp.service.impl;

import com.example.ventaapp.dto.VentaDTO;
import com.example.ventaapp.model.Venta;
import com.example.ventaapp.repository.VentaRepository;
import com.example.ventaapp.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta crearVenta(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setProducto(ventaDTO.getProducto());
        venta.setCantidad(ventaDTO.getCantidad());
        venta.setPrecio(ventaDTO.getPrecio());
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> eliminarVenta(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        venta.ifPresent(ventaRepository::delete);
        return venta;
    }
}