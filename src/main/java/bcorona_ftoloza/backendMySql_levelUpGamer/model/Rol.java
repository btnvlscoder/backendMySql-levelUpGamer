package bcorona_ftoloza.backendMySql_levelUpGamer.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import bcorona_ftoloza.backendMySql_levelUpGamer.util.Util;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    private String id;
    private String nombre; // "LEVELUPGAMER", "USUARIO DUOC", "ADMIN", "SOPORTE"
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<Usuario> usuarios; 

    @PrePersist
    public void GeneradorAutoId() {
        if (this.id == null) {
            this.id = Util.generarID();
        }
    }
}