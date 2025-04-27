package Persona;

import Data.DataManager;
import java.util.List;
import Utils.Input;

public class InicioSesion {

    public static List<Usuario> usuarios = DataManager.getUsuarios();
    public static Usuario usuarioLogueado;

    public static void iniciarSesion() {
        System.out.println("""
                \n=================== INICIO DE SESIÓN =================
                Por favor, ingrese sus credenciales.
                ======================================================""");
        System.out.print("Usuario: ");
        String usuarioIngresado = Input.scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasenaIngresada = Input.scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(usuarioIngresado)) {

                if (u.getPassword().equals(contrasenaIngresada)) {
                    usuarioLogueado = u;
                    menuRol();
                    return;
                } else {
                    System.out.println("Contraseña incorrecta!");
                    return;
                }
            }
        }

        System.out.println("Usuario no encontrado!");
    }

    private static void menuRol() {
        switch (usuarioLogueado.getRol()) {
            case "Microempresario" -> Microempresario.menuMicroempresario();
            case "Vendedor" -> Vendedor.menuVendedor();
            default -> System.out.println("Rol no reconocido");
        }
    }

}
