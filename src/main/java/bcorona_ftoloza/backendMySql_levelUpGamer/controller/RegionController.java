package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Region;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;
    @GetMapping("/listar")
    public List<Region> listarRegiones() {
        return regionService.listar();
    }
    @PostMapping("/agregarRegion")
    public void agregarRegion(@RequestBody Region region) {
        regionService.agregarRegion(region);
    }
    @PostMapping("/agregarListaRegion")
    public void agregarRegion(@RequestBody List<Region> regiones) {
        for (Region region : regiones) {
            regionService.agregarRegion(region);
        }
    }


}
