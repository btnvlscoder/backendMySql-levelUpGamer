package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// --- ¡NUEVOS IMPORTS NECESARIOS! ---
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.CrearVentaRequestDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.VentaItemDTO;
// ---

import bcorona_ftoloza.backendMySql_levelUpGamer.dto.VentaDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Venta;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.VentaRepository;
import org.springframework.transaction.annotation.Transactional; // Importante para la consistencia

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // --- ¡NUEVO MÉTODO PARA PROCESAR EL CARRITO COMPLETO! ---
    /**
     * Procesa una solicitud de venta completa desde la aplicación móvil.
     * Recibe una lista de items y los guarda como registros de venta individuales.
     * Usa @Transactional para asegurar que si una inserción falla, ninguna se complete.
     *
     * @param ventaRequest El DTO que contiene la lista de ítems y el total.
     * @return Una respuesta HTTP 201 (Created) si tiene éxito, o 500 si hay un error.
     */
    @Transactional // Anotación clave: Si algo falla, revierte todos los 'save'.
    public ResponseEntity<?> agregarVentaCompleta(CrearVentaRequestDTO ventaRequest) {
        try {
            // Itera sobre cada ítem recibido desde la app móvil.
            for (VentaItemDTO item : ventaRequest.getItems()) {
                Venta venta = new Venta();
                venta.setNombreProducto(item.getNombreProducto());
                venta.setCantidad(item.getCantidad());
                venta.setPrecio(item.getPrecio());
                
                // Calcula el valor total para esta fila (precio * cantidad).
                BigDecimal valor = item.getPrecio().multiply(new BigDecimal(item.getCantidad()));
                venta.setValor(valor);

                // Guarda cada ítem como una fila separada en la tabla 'ventas'.
                ventaRepository.save(venta);
            }
            
            // Si el bucle se completa sin errores, responde con un 201 Created.
            return ResponseEntity.status(HttpStatus.CREATED).build();
            
        } catch (Exception e) {
            // Si ocurre cualquier excepción durante el proceso, devuelve un error 500.
            // Gracias a @Transactional, la base de datos no quedará en un estado inconsistente.
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la venta completa: " + e.getMessage());
        }
    }


    // --- EL RESTO DE TUS MÉTODOS ORIGINALES PERMANECEN IGUAL ---

    private VentaDTO toDto(Venta v) {
        if (v == null) return null;
        VentaDTO d = new VentaDTO();
        d.setId(v.getId());
        d.setNombreProducto(v.getNombreProducto());
        d.setCantidad(v.getCantidad());
        d.setPrecio(v.getPrecio());
        d.setValor(v.getValor());
        return d;
    }

    private Venta toEntity(VentaDTO d) {
        if (d == null) return null;
        Venta v = new Venta();
        v.setId(d.getId());
        v.setNombreProducto(d.getNombreProducto());
        v.setCantidad(d.getCantidad());
        v.setPrecio(d.getPrecio());
        v.setValor(d.getValor());
        return v;
    }

    public ResponseEntity<?> agregarVenta(VentaDTO dto) {
        Venta v = toEntity(dto);
        Venta saved = ventaRepository.save(v);
        return ResponseEntity.ok(toDto(saved));
    }

    public List<VentaDTO> listarVentas() {
        List<VentaDTO> salida = new ArrayList<>();
        List<Venta> ventas = ventaRepository.findAll();
        for (Venta v : ventas) {
            salida.add(toDto(v));
        }
        return salida;
    }

    public VentaDTO obtenerVenta(Long id) {
        return ventaRepository.findById(id).map(this::toDto).orElse(null);
    }

    public ResponseEntity<?> actualizarVenta(Long id, VentaDTO dto) {
        var opt = ventaRepository.findById(id);
        if (opt.isPresent()) {
            Venta existing = opt.get();
            existing.setNombreProducto(dto.getNombreProducto());
            existing.setCantidad(dto.getCantidad());
            existing.setPrecio(dto.getPrecio());
            existing.setValor(dto.getValor());
            Venta saved = ventaRepository.save(existing);
            return ResponseEntity.ok(toDto(saved));
        } else {
            return ResponseEntity.status(404).body("Venta no encontrada");
        }
    }

    public ResponseEntity<?> eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return ResponseEntity.ok("Venta eliminada");
        } else {
            return ResponseEntity.status(404).body("Venta no encontrada");
        }
    }
}
