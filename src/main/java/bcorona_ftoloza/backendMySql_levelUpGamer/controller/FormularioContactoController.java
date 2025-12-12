package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.FormularioContacto;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.FormularioContactoService;

@RestController
@RequestMapping("/tickets")
public class FormularioContactoController {

    @Autowired
    private FormularioContactoService formularioService;

    @GetMapping("/usuario/{email:.+}")
    public ResponseEntity<List<FormularioContacto>> obtenerTicketsPorUsuario(@PathVariable String email) {
        System.out.println("Solicitud recibida para tickets del email: " + email);
        List<FormularioContacto> tickets = formularioService.listarPorUsuario(email);
        System.out.println("Tickets encontrados: " + tickets.size());
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public ResponseEntity<?> crearTicket(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String asunto = payload.get("asunto");
        String mensaje = payload.get("mensaje");

        if (email == null || asunto == null || mensaje == null) {
            return ResponseEntity.badRequest().body("Faltan datos");
        }

        try {
            FormularioContacto nuevoTicket = formularioService.crearTicket(email, asunto, mensaje);
            return ResponseEntity.ok(nuevoTicket);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
