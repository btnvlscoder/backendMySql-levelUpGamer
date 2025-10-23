package bcorona_ftoloza.backendMySql_levelUpGamer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByEmail(String email);
}
