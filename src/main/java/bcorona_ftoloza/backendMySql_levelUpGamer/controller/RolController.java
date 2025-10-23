package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Rol;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.RolService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @PostMapping
    public String agregarRol(@RequestBody Rol rol) {
        return rolService.agregarRol(rol);
    }

    @PostMapping("/agregarlista")
    public ResponseEntity<String> agregarListaRoles(@RequestBody List<Rol> roles) {
        for (Rol rol : roles) {
            rolService.agregarRol(rol);
        }
        return ResponseEntity.ok("Roles almacenados correctamente");
    }

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarRoles();
    }
}
