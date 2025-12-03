package bcorona_ftoloza.backendMySql_levelUpGamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Rol;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RolRepository;

@SpringBootApplication
public class BackendMySqlLevelUpGamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendMySqlLevelUpGamerApplication.class, args);
    }

    @Bean
    CommandLineRunner seedRoles(RolRepository rolRepository) {
        return args -> {
            ensureRoleExists(rolRepository, "LEVELUPGAMER");
            ensureRoleExists(rolRepository, "DUOCUC");
        };
    }

    private void ensureRoleExists(RolRepository rolRepository, String nombre) {
        Rol existing = rolRepository.findByNombre(nombre);
        if (existing == null) {
            Rol rol = new Rol();
            rol.setNombre(nombre);
            rolRepository.save(rol);
        }
    }
}
