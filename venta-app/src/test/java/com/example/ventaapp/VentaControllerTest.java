import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.ventaapp.controller.VentaController;
import com.example.ventaapp.dto.VentaDTO;
import com.example.ventaapp.service.VentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

public class VentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VentaService ventaService;

    @InjectMocks
    private VentaController ventaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ventaController).build();
    }

    @Test
    public void testCrearVenta() throws Exception {
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setProducto("Producto 1");
        ventaDTO.setCantidad(2);
        ventaDTO.setPrecio(100.0);

        when(ventaService.crearVenta(any(VentaDTO.class))).thenReturn(ventaDTO);

        mockMvc.perform(post("/ventas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"producto\":\"Producto 1\",\"cantidad\":2,\"precio\":100.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.producto").value("Producto 1"));
    }

    @Test
    public void testObtenerVentas() throws Exception {
        when(ventaService.obtenerVentas()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/ventas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testEliminarVenta() throws Exception {
        doNothing().when(ventaService).eliminarVenta(1L);

        mockMvc.perform(delete("/ventas/1"))
                .andExpect(status().isNoContent());
    }
}