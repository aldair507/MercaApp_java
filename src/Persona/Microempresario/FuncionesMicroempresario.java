package Persona.Microempresario;

import Data.DataManager;
import static Inventario.Inventario.mostrarInventario;
import Persona.InicioSesion;
import Producto.Producto;
import Utils.Input;

public class FuncionesMicroempresario {

    public static void menuMicroempresario() {
        while (true) {
            System.out.println("\n================ MICROEMPRESARIO " + InicioSesion.usuarioLogueado.getUsername()
                    + " =================");
            System.out.print("""
                    1. Agregar producto
                    2. Actualizar producto
                    3. Actualizar stock
                    4. Ver inventario
                    5. Salir
                    =========================================================
                    """);
            System.out.print("Seleccione opción: ");

            int opcion = Input.scanner.nextInt();
            Input.scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> actualizarProducto();
                case 3 -> actualizarStock();
                case 4 -> mostrarInventario();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    public static void agregarProducto() {

        System.out.print("""
                \n=================== AGREGAR PRODUCTO ====================
                Por favor, ingrese los datos del producto.
                =========================================================
                """);

        String id = Input.getString("ID Producto: ");
        String nombre = Input.getString("Nombre: ");
        int cantidad = Input.getInt("Cantidad inicial: ");
        double precio = Input.getDouble("Precio: ");
        double descuento = Input.getDouble("Descuento: ");
        Input.scanner.nextLine();

        // Crear un nuevo producto y agregarlo al inventario de DataManager
        Producto producto = new Producto(
                id.toUpperCase(),
                capitalizarPrimeraLetra(nombre),
                cantidad,
                precio,
                descuento

        );

        DataManager.agregarProducto(producto); // Asegúrate de tener un método para agregar productos en DataManager

        System.out.println("Producto agregado!");
    }

    private static void actualizarStock() {
        mostrarInventario();

        String id = Input.getString("""
                \n=================== ACTUALIZAR STOCK ====================
                Por favor, ingrese los datos del producto.
                =========================================================
                ID Producto para actualizar stock:\t""").toUpperCase();

        for (Producto p : DataManager.getInventario()) {
            if (p.getId().equals(id)) {
                System.out.print("Nueva cantidad: ");
                p.setCantidad(Input.scanner.nextInt());
                Input.scanner.nextLine();
                System.out.println("Stock actualizado!");
                return;
            }
        }
        System.out.println("Producto no encontrado!");
    }

    public static void actualizarProducto() {
        mostrarInventario();

        String id = Input.getString("""
                \n================== ACTUALIZAR PRODUCTO ==================
                Por favor, ingrese los datos del producto.
                =========================================================
                ID Producto para actualizar:\t""").toUpperCase();

        for (Producto p : DataManager.getInventario()) {
            if (p.getId().equals(id)) {

                System.out.print("Nuevo nombre: ");
                p.setNombre(capitalizarPrimeraLetra(Input.scanner.nextLine()));

                System.out.print("Nueva cantidad: ");
                p.setPrecio(Input.scanner.nextInt());

                System.out.print("Nuevo precio: ");
                p.setPrecio(Input.scanner.nextDouble());

                Input.scanner.nextLine();
                System.out.println("Producto actualizado!");
                return;
            }
        }
        System.out.println("Producto no encontrado!");
    }

    private static String capitalizarPrimeraLetra(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
