package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public UsuarioDTO validarCredenciales(@RequestBody LoginDTO dto) {
        return usuarioService.validarCredenciales(dto);
    }
}
