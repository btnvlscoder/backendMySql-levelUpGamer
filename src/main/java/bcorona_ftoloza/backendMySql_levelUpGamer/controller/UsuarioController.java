package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.UsuarioDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listar();
    }

    @PostMapping
    public void agregarUsuario(@RequestBody UsuarioDTO dto) {
        usuarioService.agregarUsuario(dto);
    }

    
}
