package bcorona_ftoloza.backendMySql_levelUpGamer.service;

import bcorona_ftoloza.backendMySql_levelUpGamer.model.Producto;
import bcorona_ftoloza.backendMySql_levelUpGamer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public void guardarTodos(List<Producto> productos) {
        productoRepository.saveAll(productos);
    }
}
