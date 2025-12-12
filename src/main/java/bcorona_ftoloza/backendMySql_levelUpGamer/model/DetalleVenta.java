package bcorona_ftoloza.backendMySql_levelUpGamer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
}
