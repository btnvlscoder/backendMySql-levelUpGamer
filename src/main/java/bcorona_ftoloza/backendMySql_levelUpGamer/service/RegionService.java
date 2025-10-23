package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RegionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public ResponseEntity <?> agregarRegion(Region region) {
    if(regionRepository.findByNombre(region.getNombre())!=null){
        return ResponseEntity
            .badRequest()
            .body("El nombre de la región ya existe");
    } 

    regionRepository.save(region);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(region);
    }

    public List<Region> obtenerTodasLasRegiones() {
        return regionRepository.findAll();
    }
}
