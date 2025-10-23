package bcorona_ftoloza.backendMySql_levelUpGamer.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String email;
    private String password;
    private LocalDate fechaRegistro;
    private Boolean activo; //  ---> activo o inactivo
}