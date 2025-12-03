package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{
    Region findByNombre(String nombre);

}
