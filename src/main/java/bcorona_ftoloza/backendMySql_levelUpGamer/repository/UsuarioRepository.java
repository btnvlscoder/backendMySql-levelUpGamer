package bcorona_ftoloza.backendMySql_levelUpGamer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    public Boolean existsByEmailAndPassword(String email, String password);
}
