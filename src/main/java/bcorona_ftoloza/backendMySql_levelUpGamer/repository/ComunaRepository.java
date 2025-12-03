package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Comuna;

public interface ComunaRepository extends JpaRepository<Comuna, Integer>{
    Comuna findByNombre(String nombre);
    List<Comuna> findByRegionId(Integer regionId);

}
