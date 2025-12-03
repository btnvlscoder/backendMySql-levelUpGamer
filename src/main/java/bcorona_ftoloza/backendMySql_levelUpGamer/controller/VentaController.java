package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcorona_ftoloza.backendMySql_levelUpGamer.dto.CrearVentaRequestDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.VentaDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.VentaService;

// En VentaController.java

@RestController
@RequestMapping("/ventas")
// ¡IMPORTANTE! Añade @CrossOrigin para evitar problemas de CORS durante el desarrollo
@CrossOrigin(origins = "*") 
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // --- NUEVO MÉTODO PARA PROCESAR EL CARRITO COMPLETO ---
    @PostMapping("/completa") // Usamos una URL diferente: /ventas/completa
    public ResponseEntity<?> agregarVentaCompleta(@RequestBody CrearVentaRequestDTO ventaRequest) {
        // Llama a un nuevo método en tu servicio
        return ventaService.agregarVentaCompleta(ventaRequest);
    }

    // ... (Tus otros métodos como agregarVenta, listarVentas, etc., pueden quedar como estaban)



    @GetMapping
    public List<VentaDTO> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVenta(@PathVariable Long id) {
        VentaDTO v = ventaService.obtenerVenta(id);
        if (v != null) return ResponseEntity.ok(v);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody VentaDTO dto) {
        return ventaService.actualizarVenta(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        return ventaService.eliminarVenta(id);
    }
}
