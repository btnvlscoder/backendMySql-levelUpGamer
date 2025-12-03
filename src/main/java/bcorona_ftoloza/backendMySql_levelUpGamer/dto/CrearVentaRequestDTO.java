// Archivo: CrearVentaRequestDTO.java
package bcorona_ftoloza.backendMySql_levelUpGamer.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class CrearVentaRequestDTO {
    private List<VentaItemDTO> items;
    private BigDecimal total;
    // Puedes añadir aquí el id del cliente si lo necesitas
}
