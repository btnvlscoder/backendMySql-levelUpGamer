package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
}
