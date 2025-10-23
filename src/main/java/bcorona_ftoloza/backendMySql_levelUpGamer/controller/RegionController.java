package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> obtenerTodasLasRegiones() {
        return regionService.obtenerTodasLasRegiones();
    }

    @PostMapping
    public ResponseEntity<?> agregarRegion(@RequestBody Region region) {
        return regionService.agregarRegion(region);
    }

    @PostMapping("/agregarlista")
    public ResponseEntity<String> agregarListaRegiones(@RequestBody List<Region> regiones) {
        for (Region region : regiones) {
            regionService.agregarRegion(region);
        }
        return ResponseEntity.ok("Regiones almacenadas correctamente");
    }

}
