package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.FormularioContacto;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.FormularioContactoRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.UsuarioRepository;

@Service
public class FormularioContactoService {

    @Autowired
    private FormularioContactoRepository formularioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<FormularioContacto> listarPorUsuario(String email) {
        return formularioRepository.findByUsuario_Email(email);
    }

    public FormularioContacto crearTicket(String email, String asunto, String mensaje) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        FormularioContacto formulario = new FormularioContacto();
        formulario.setAsunto(asunto);
        formulario.setMensaje(mensaje);
        formulario.setEstado("ABIERTO");
        formulario.setFechaEnvio(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        formulario.setUsuario(usuario);

        return formularioRepository.save(formulario);
    }
}
