package bcorona_ftoloza.backendMySql_levelUpGamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.FormularioContacto;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Usuario;

@Repository
public interface FormularioContactoRepository extends JpaRepository<FormularioContacto, Integer> {
    List<FormularioContacto> findByUsuario(Usuario usuario);
    List<FormularioContacto> findByUsuario_Email(String email);
}
