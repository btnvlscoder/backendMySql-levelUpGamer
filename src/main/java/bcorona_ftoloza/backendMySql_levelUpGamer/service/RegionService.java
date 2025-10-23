package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public String agregarRegion(Region region) {
        Region validacion = regionRepository.findByNombre(region.getNombre());
        if(validacion == null) {
            regionRepository.save(region);
            return "Region almacenada correctamente!";
        } else {
            return "Region ya ingresada!";
        }
    }

    public List<Region> listarRegion() {
        return regionRepository.findAll();
    }
}
