package bcorona_ftoloza.backendMySql_levelUpGamer.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private String email;
    private String password;
    @JsonFormat(pattern="dd-MM-yyyy 00:00:00")
    private LocalDate fechaRegistro;
    private Boolean activo; //  ---> activo o inactivo

    @ManyToOne
    @JoinColumn
    (name = "persona_rut")
    private Persona persona;
    @ManyToOne
    @JoinColumn
    (name = "rol_id")
    private Rol rol;
    @OneToMany
    (mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormularioContacto> formulariosContacto;
    

    @PrePersist
    public void setFechaRegistro() {
        this.fechaRegistro = LocalDate.now();
    }

 }