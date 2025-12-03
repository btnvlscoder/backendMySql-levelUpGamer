package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcorona_ftoloza.backendMySql_levelUpGamer.dto.LoginDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.UsuarioDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> agregarUsuario(@RequestBody UsuarioDTO dto) {
        return usuarioService.agregarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuario();
    }

    @PostMapping("/login")
    public ResponseEntity<?> validarCredenciales(@RequestBody LoginDTO dto) { 
        UsuarioDTO usuario = usuarioService.validarCredenciales(dto);
        
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña incorrectos");
        }
    }
}
