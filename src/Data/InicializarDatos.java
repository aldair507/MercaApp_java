package Data;

import Interfaces.IUsuario;
import Persona.Administrador.Administrador;
import Persona.Microempresario.Microempresario;
import Persona.Vendedor.Vendedor;
import Producto.Producto;

import java.util.List;

public class InicializarDatos {

    public List<IUsuario> usuarios = DataManager.getUsuarios();
    public List<Producto> inventario = DataManager.getInventario();

    public void inicializarDatos() {
        // Usuarios pre-registrados
        DataManager.agregarUsuario(new Administrador("admin1", "admin123", 1, "Administrador"));
        DataManager.agregarUsuario(new Microempresario("micro1", "micro123", 2, "Microempresario"));
        DataManager.agregarUsuario(new Vendedor("vend1", "vend123", 3, "Vendedor"));

        // Productos iniciales
        DataManager.agregarProducto(new Producto("P001", "Papa", 10, 1500.0,  10));
        DataManager.agregarProducto(new Producto("P002", "Yuca", 10, 2500.0,  10));
    }

}
