package bcorona_ftoloza.backendMySql_levelUpGamer;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Producto;
import bcorona_ftoloza.backendMySql_levelUpGamer.model.Rol;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.ProductoRepository;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RolRepository rolRepository;
    private final ProductoRepository productoRepository;

    public DataSeeder(RolRepository rolRepository, ProductoRepository productoRepository) {
        this.rolRepository = rolRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
        seedProducts();
    }

    private void seedRoles() {
        if (rolRepository.count() == 0) {
            Rol roleDuoc = new Rol();
            roleDuoc.setNombre("DUOCUC");
            rolRepository.save(roleDuoc);

            Rol roleLevelUp = new Rol();
            roleLevelUp.setNombre("LEVELUPGAMER");
            rolRepository.save(roleLevelUp);
            
            System.out.println("Roles sembrados: DUOCU, LEVELUPGAMER");
        }
    }

    private void seedProducts() {
        if (productoRepository.count() == 0) {
            Producto p1 = new Producto(
                    "JM001",
                    "Juegos de Mesa",
                    "Devir",
                    "Catan",
                    new BigDecimal("29990"),
                    "Un clásico juego de estrategia donde los jugadores compiten por colonizar y expandirse en la isla de Catan."
            );

            Producto p2 = new Producto(
                    "JM002",
                    "Juegos de Mesa",
                    "Devir",
                    "Carcassonne",
                    new BigDecimal("24990"),
                    "Juego de colocación de fichas donde los jugadores construyen el paisaje medieval de Carcassonne."
            );

            Producto p3 = new Producto(
                    "AC001",
                    "Accesorios",
                    "Microsoft",
                    "Controlador Inalámbrico Xbox Series X",
                    new BigDecimal("59990"),
                    "Experiencia de juego cómoda con botones mapeables y respuesta táctil mejorada."
            );

            Producto p4 = new Producto(
                    "AC002",
                    "Accesorios",
                    "HyperX",
                    "Auriculares Gamer HyperX Cloud II",
                    new BigDecimal("79990"),
                    "Sonido envolvente de calidad con micrófono desmontable y almohadillas ultra cómodas."
            );

            Producto p5 = new Producto(
                    "CO001",
                    "Consolas",
                    "Sony",
                    "PlayStation 5",
                    new BigDecimal("549990"),
                    "Consola de última generación de Sony con gráficos impresionantes y carga ultrarrápida."
            );

            Producto p6 = new Producto(
                    "CG001",
                    "Computadores Gamers",
                    "ASUS",
                    "PC Gamer ASUS ROG Strix",
                    new BigDecimal("1299990"),
                    "Potente equipo diseñado para gamers exigentes, con rendimiento excepcional en cualquier juego."
            );

            Producto p7 = new Producto(
                    "SG001",
                    "Sillas Gamers",
                    "Secretlab",
                    "Silla Gamer Secretlab Titan",
                    new BigDecimal("349990"),
                    "Máximo confort y soporte ergonómico para sesiones largas de juego."
            );

            Producto p8 = new Producto(
                    "MS001",
                    "Mouse",
                    "Logitech",
                    "Mouse Gamer Logitech G502 HERO",
                    new BigDecimal("49990"),
                    "Sensor de alta precisión y botones personalizables para un control preciso."
            );

            Producto p9 = new Producto(
                    "MP001",
                    "Mousepad",
                    "Razer",
                    "Mousepad Razer Goliathus Extended Chroma",
                    new BigDecimal("29990"),
                    "Área amplia de juego con iluminación RGB personalizable."
            );

            Producto p10 = new Producto(
                    "PP001",
                    "Poleras Personalizadas",
                    "Level-Up",
                    "Polera Gamer Personalizada 'Level-Up'",
                    new BigDecimal("14990"),
                    "Camiseta cómoda y estilizada, personalizable con tu gamer tag o diseño favorito."
            );

            productoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
            System.out.println("Productos sembrados desde LocalProductDataSource.");
        }
    }
}
