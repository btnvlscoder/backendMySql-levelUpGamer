package bcorona_ftoloza.backendMySql_levelUpGamer.service;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RegionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.ComunaDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Comuna;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.ComunaRepository;

@Service
public class ComunaService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> obtenerTodasLasComunas(){
        return comunaRepository.findAll();
    }

    public List<Comuna> listarComunasPorRegion(Integer regionId) {
        return comunaRepository.findByRegionId(regionId);
    }

    public ResponseEntity<?> agregarComuna(ComunaDTO dto) {
        Region region = regionRepository.findById(dto.getRegionId()).orElse(null);
        if (region == null) {
            return ResponseEntity
                    .badRequest()
                    .body("El ID de la región no existe.");
        }
        
        if (comunaRepository.findByNombre(dto.getNombre()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body("El nombre de la comuna ya existe.");
        }



        Comuna nuevaComuna = new Comuna();
        nuevaComuna.setNombre(dto.getNombre());
        nuevaComuna.setRegion(region);

        comunaRepository.save(nuevaComuna); 

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaComuna);
    }
}