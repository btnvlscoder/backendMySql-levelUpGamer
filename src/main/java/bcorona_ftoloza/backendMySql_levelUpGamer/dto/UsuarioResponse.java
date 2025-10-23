package bcorona_ftoloza.backendMySql_levelUpGamer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private String estado;
    private String mensaje;
    private UsuarioDTO usuarioDTO;

}
