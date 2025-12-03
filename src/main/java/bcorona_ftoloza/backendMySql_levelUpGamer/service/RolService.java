package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Rol;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;


    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }
    
    public String agregarRol(Rol rol) {
        Rol validacion = rolRepository.findByNombre(rol.getNombre());
        if(validacion == null) {
            rolRepository.save(rol);
            return "Rol almacenado correctamente!";
        } else {
            return "Rol ya ingresado!";
        }
    }
}