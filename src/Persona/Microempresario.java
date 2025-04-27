package Persona;

import Producto.Producto;
import java.util.Scanner;
import Data.DataManager;
import Inventario.Inventario;

public class Microempresario {

    public static Scanner scanner = new Scanner(System.in);

    public static void menuMicroempresario() {
        while (true) {
            System.out.println(""" 
                    === MICROEMPRESARIO ===
                    1. Agregar producto
                    2. Actualizar stock
                    3. Ver inventario
                    4. Salir
                    """);
            System.out.print("Seleccione opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> actualizarStock();
                case 3 -> Inventario.mostrarInventario();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private static void agregarProducto() {
        System.out.print("ID Producto: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad inicial: ");
        int cantidad = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        // Crear un nuevo producto y agregarlo al inventario de DataManager
        Producto producto = new Producto(id, nombre, cantidad, precio);
        DataManager.agregarProducto(producto);  // Asegúrate de tener un método para agregar productos en DataManager

        System.out.println("Producto agregado!");
    }

    private static void actualizarStock() {
        Inventario.mostrarInventario();
        System.out.print("ID Producto a actualizar: ");
        String id = scanner.nextLine();

        for (Producto p : DataManager.getInventario()) {  // Cambiar para obtener productos desde DataManager
            if (p.getId().equals(id)) {
                System.out.print("Nueva cantidad: ");
                p.setCantidad(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Stock actualizado!");
                return;
            }
        }
        System.out.println("Producto no encontrado!");
    }
}
