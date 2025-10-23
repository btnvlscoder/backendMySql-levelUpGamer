package bcorona_ftoloza.backendMySql_levelUpGamer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    private String numero;
    private String referencia;
    private boolean esPrincipal;
    @ManyToOne
    @JoinColumn(name = "comuna_id") 
    private Comuna comuna;
    
    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Usuario> usuarios;

}

