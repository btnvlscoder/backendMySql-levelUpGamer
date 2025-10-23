package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import bcorona_ftoloza.backendMySql_levelUpGamer.dto.LoginDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.UsuarioDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.UsuarioResponse;
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
    public ResponseEntity<?> agregarUsuario(UsuarioDTO dto) {
        UsuarioResponse uResponse = new UsuarioResponse();

        if (usuarioRepository.existsById(dto.getEmail())) {
            uResponse.setEstado("ERROR");
            uResponse.setMensaje("El email ingresado ya existe.");
            return ResponseEntity.ok(uResponse);
        }

        if(personaRepository.existsById(dto.getRut())) {
            uResponse.setEstado("ERROR");
            uResponse.setMensaje("El RUT ingresado ya existe.");
            return ResponseEntity.ok(uResponse);
        }

        Persona persona= new Persona();
        Usuario usuario = new Usuario();

        persona.setRut(dto.getRut());
        persona.setNombre(dto.getNombre());
        persona.setApellidoPaterno(dto.getApellidoPaterno());
        persona.setApellidoMaterno(dto.getApellidoMaterno());

        personaRepository.save(persona);
        
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setPersona(persona);

        usuarioRepository.save(usuario);

        uResponse.setEstado("OK");
        uResponse.setMensaje("Usuario agregado correctamente");
        uResponse.setUsuarioDTO(dto);

        return ResponseEntity.ok(uResponse);
    }


    public List<UsuarioDTO> listarUsuario() {
        List<UsuarioDTO> listafinal = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setEmail(u.getEmail());
            dto.setPassword("**********");

            Persona persona = u.getPersona();
            if (persona != null) {
                dto.setRut(persona.getRut());
                dto.setNombre(persona.getNombre());
                dto.setApellidoPaterno(persona.getApellidoPaterno());
                dto.setApellidoMaterno(persona.getApellidoMaterno());
            }else{
                dto.setRut("Usuario sin persona asignado");
            }

            listafinal.add(dto);
        }

        return listafinal;
    }

    public UsuarioDTO validarCredenciales(LoginDTO dto) {
        boolean validador = usuarioRepository.existsByEmailAndPassword(dto.getEmail(), dto.getPassword());
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        if (validador) {
            Usuario usuario = this.usuarioRepository.findById(dto.getEmail()).orElse(null);

            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setPassword("**********");   
            usuarioDTO.setRut(usuario.getPersona().getRut());
            usuarioDTO.setNombre(usuario.getPersona().getNombre());
            usuarioDTO.setApellidoPaterno(usuario.getPersona().getApellidoPaterno());
            usuarioDTO.setApellidoMaterno(usuario.getPersona().getApellidoMaterno());
        
            return usuarioDTO;
        } else {
            return new UsuarioDTO();
        } 
    }
}