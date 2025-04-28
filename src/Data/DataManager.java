package Data;

import Interfaces.IUsuario;
import Persona.Administrador.FuncionesAdministrador;
import Producto.Producto;
import Venta.Venta;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    // Arreglos globales
    private static final List<IUsuario> usuarios = new ArrayList<>();
    private static final List<Producto> inventario = new ArrayList<>();
    private static final List<Venta> ventas = new ArrayList<>();

    // Métodos estáticos para acceder a los arreglos
    public static List<IUsuario> getUsuarios() {
        return usuarios;
    }

    public static List<Producto> getInventario() {
        return inventario;
    }

    public static List<Venta> getVentas() {
        return ventas;
    }

    // Métodos para agregar elementos
    public static void agregarUsuario(IUsuario usuario) {
        usuarios.add(usuario);
    }

    public static void setUsuarios(List<IUsuario> usuarios) {

        FuncionesAdministrador.actualizarUsuario(usuarios.get(0));
    }

    public static void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public static void agregarVenta(Venta venta) {
        ventas.add(venta);
    }
}
