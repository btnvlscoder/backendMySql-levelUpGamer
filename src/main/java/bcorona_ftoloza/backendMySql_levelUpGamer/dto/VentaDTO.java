package bcorona_ftoloza.backendMySql_levelUpGamer.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long id;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal valor;
}
