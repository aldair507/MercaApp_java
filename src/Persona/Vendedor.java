package Persona;

import Data.DataManager;
import Inventario.Inventario;
import Producto.Producto;
import Utils.Input;
import Venta.CalculoConIVA;
import Venta.Venta;
import java.util.List;

/**
 * Esta clase representa al vendedor en el sistema.
 * Permite realizar ventas y ver el historial de ventas.
 */

public class Vendedor {

    public static void menuVendedor() {
        while (true) {

            System.out.println("\n===================== VENDEDOR " + InicioSesion.usuarioLogueado.getUsername()
                    + " ====================");
            System.out.print("""
                    1. Nueva venta
                    2. Ver ventas
                    3. Salir
                    """);

            int opcion = Input.getInt("Seleccione opción: ");
            Input.scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> realizarVenta();
                case 2 -> mostrarVentas();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    public static void realizarVenta() {
        Venta venta = new Venta(new CalculoConIVA());
        String continuar;

        do {
            // Mostrar inventario actualizado
            Inventario.mostrarInventario();

            System.out.print("ID Producto a vender: ");
            String id = Input.scanner.nextLine().toUpperCase();

            List<Producto> inventario = DataManager.getInventario();
            boolean productoEncontrado = false;

            for (Producto p : inventario) {

                if (p.getId().equals(id) && p.getCantidad() > 0) {
                    productoEncontrado = true;

                    int cantidad = Input.getInt("Cantidad: ");
                    Input.scanner.nextLine(); // Limpiar el buffer

                    // Verificar si hay suficiente stock
                    if (p.getCantidad() >= cantidad) {
                        // Agregar el producto a la venta
                        venta.agregarProducto(p, cantidad);

                        // Actualizar el stock del producto
                        p.setCantidad(p.getCantidad() - cantidad);

                        System.out.println("Producto agregado a la venta!");
                        break;
                    } else {
                        System.out.println("Stock insuficiente!");
                        break;
                    }
                }
            }

            if (!productoEncontrado) {
                System.out.println("Producto no encontrado o agotado.");
            }

            // Preguntar si el vendedor desea agregar otro producto
            System.out.print("¿Agregar otro producto? (s/n): ");
            continuar = Input.scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        // Registrar la venta después de finalizar la compra
        DataManager.agregarVenta(venta);
        System.out.println("\nVenta registrada! Total: $" + venta.calcularTotal());
    }

    public static void mostrarVentas() {
        List<Venta> ventas = DataManager.getVentas();
        int contador = 1;
        double sumatoriaVenta = 0;

        if (ventas.isEmpty()) {
            System.out.println("\nNo hay ventas registradas.");
            return;
        }

        for (Venta v : ventas) {

            System.out.println("\n========================= Venta " + contador++ + " =======================");

            sumatoriaVenta += v.calcularTotal();
            System.out.println(v);

        }

        System.out.println("============ Total ventas del dia : $" + sumatoriaVenta + " ============");
    }

}
