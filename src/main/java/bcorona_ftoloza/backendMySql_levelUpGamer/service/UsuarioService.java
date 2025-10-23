package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.UsuarioDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Persona;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.PersonaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    //dto
    public void agregarUsuario(UsuarioDTO dto) {
        Persona persona= new Persona();

        persona.setRut(dto.getRut());
        persona.setNombre(dto.getNombre());
        persona.setApellidoPaterno(dto.getApellidoPaterno());
        persona.setApellidoMaterno(dto.getApellidoMaterno());
        persona.setTelefono(dto.getTelefono());

        personaRepository.save(persona);
        
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        usuarioRepository.save(usuario);
    }


    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}