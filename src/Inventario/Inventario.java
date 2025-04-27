package Inventario;

import java.util.List;

import Data.DataManager;
import Producto.Producto;

public class Inventario {
    public static void mostrarInventario() {
        List<Producto> inventario = DataManager.getInventario();
    
        System.out.println("\n===== INVENTARIO DISPONIBLE =====");
        // Solo mostrar productos con cantidad mayor a 0
        for (Producto p : inventario) {
            if (p.getCantidad() > 0) { // Verificar que el stock sea mayor a 0
                System.out.println("ID: " + p.getId() +
                        " | Nombre: " + p.getNombre() +
                        " | Cantidad: " + p.getCantidad() +
                        " | Precio: $" + p.getPrecio());
            }
        }
        System.out.println("==================================\n");
    }
    
}
