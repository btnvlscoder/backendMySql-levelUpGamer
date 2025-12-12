package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Venta;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.UsuarioRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Venta crearVenta(Venta venta) {
        if (venta.getFecha() == null) {
            venta.setFecha(LocalDateTime.now());
        }
        
        // Link user if provided
        if (venta.getUsuario() != null && venta.getUsuario().getEmail() != null) {
            Usuario usuario = usuarioRepository.findById(venta.getUsuario().getEmail()).orElse(null);
            if (usuario != null) {
                venta.setUsuario(usuario);
            }
        }

        // Link details to sale if not linked
        if (venta.getDetalles() != null) {
            venta.getDetalles().forEach(detalle -> detalle.setVenta(venta));
        }
        return ventaRepository.save(venta);
    }
}
