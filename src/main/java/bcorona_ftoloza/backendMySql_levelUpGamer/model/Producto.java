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
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "marca")
    private String marca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

}
