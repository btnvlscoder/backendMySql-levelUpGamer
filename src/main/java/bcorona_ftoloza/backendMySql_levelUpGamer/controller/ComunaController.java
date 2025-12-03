package bcorona_ftoloza.backendMySql_levelUpGamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bcorona_ftoloza.backendMySql_levelUpGamer.dto.ComunaDTO;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Comuna;
import bcorona_ftoloza.backendMySql_levelUpGamer.service.ComunaService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/comuna")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public List<Comuna> obtenerTodasLasComunas() {
        return comunaService.obtenerTodasLasComunas();
    }

    @PostMapping
    public ResponseEntity<?> agregarComuna(@RequestBody ComunaDTO comuna) {
        return comunaService.agregarComuna(comuna);
    }

    @PostMapping("/agregarlista")
    public ResponseEntity<String> agregarListaComunas(@RequestBody List<ComunaDTO> comunas) {
        for (ComunaDTO comuna : comunas) {
            comunaService.agregarComuna(comuna);
        }
        return ResponseEntity.ok("Comunas almacenadas correctamente");
    }

}
