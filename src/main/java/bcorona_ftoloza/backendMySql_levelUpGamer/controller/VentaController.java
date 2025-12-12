package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Venta;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.crearVenta(venta);
        return ResponseEntity.ok(nuevaVenta);
    }
}
