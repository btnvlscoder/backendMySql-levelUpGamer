package bcorona_ftoloza.backendMySql_levelUpGamer.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String fechaNacimiento;

    @OneToMany(mappedBy = "persona")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Usuario> usuarios;

}

