// Archivo: VentaItemDTO.java
package bcorona_ftoloza.backendMySql_levelUpGamer.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class VentaItemDTO {
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precio;
}
