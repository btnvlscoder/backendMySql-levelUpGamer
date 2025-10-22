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

//definimos el controlador con restcontroller
@RestController
@RequestMapping("/regiones")//creamos la ruta principal del controlador "/regiones"
public class RegionController {
    //inyectamos el servicio del modelo del controlador
    @Autowired
    private RegionService regionService;
    //getmapping para configurar la ruta listar, en donde se mostraran todas las regiones almacenadas
    @GetMapping("/listar")
    public List<Region> listarRegiones() {
        return regionService.listar();
    }
    //postmapping para configurar la ruta agregarRegion, en donde se podra agregar una nueva region
    @PostMapping("/agregarRegion")
    public void agregarRegion(@RequestBody Region region) {
        regionService.agregarRegion(region);
    }
    //este postmapping es para agregar una lista de regiones, util para poblar la base de datos como las regiones de chile son fijas
    @PostMapping("/agregarListaRegion")
    public void agregarRegion(@RequestBody List<Region> regiones) {
        for (Region region : regiones) {
            regionService.agregarRegion(region);
        }
    }
    /*despues de crear el controlador, se debe probar en postman
    seleccionas el metodo get o post y pruebas las diferentes rutas, recuerda que es 
    http://localhost:8080/regiones/listar o http://localhost:8080/regiones/agregarRegion
    se agregan en formato json, puedes pasarle el modelo a una ia para que te genere datos de prueba
    ejemplo de json para agregarRegion
    
    {
        "nombre": "Region de prueba"
    }
    ejemplo de json para agregarListaRegion

    [
        {
            "nombre": "Region 1"
        },
        {
            "nombre": "Region 2"
        },
        {
            "nombre": "Region 3"
        }
    ]


    y vamos que se puede! nos toca duro pero aham asi es nuestro mundo buena suerte!
    */

}
