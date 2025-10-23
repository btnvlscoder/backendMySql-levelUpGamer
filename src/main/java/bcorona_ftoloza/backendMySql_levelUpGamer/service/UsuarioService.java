package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.UsuarioRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.util.Util;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void agregarUsuario(Usuario usuario) {
        Util util = new Util();
        usuario.setId(util.generarID());
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }
}