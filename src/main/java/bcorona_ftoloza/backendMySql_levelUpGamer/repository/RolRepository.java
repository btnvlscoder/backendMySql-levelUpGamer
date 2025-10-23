package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Rol;

public interface RolRepository extends JpaRepository<Rol, String>{
    Rol findByNombre(String nombre);
}
