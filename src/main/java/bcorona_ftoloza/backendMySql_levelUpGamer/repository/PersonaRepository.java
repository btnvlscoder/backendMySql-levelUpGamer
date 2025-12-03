package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String>{
    Persona findByRut(String rut);
}
