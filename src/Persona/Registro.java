package Persona;

import Data.DataManager;
import Utils.Input;

public class Registro {

    public static void registrarUsuario() {
        String user;
        String pass;
        String rol;
        boolean rolValido = false;

        System.out.println("=================== REGISTRO DE USUARIO =================");
        System.out.println("Por favor, complete los siguientes datos para registrarse.");
        System.out.print("Usuario: ");
        user = Input.scanner.nextLine();
        System.out.print("Contraseña: ");
        pass = Input.scanner.nextLine();

        do {
            System.out.print("Rol (Microempresario (M) /Vendedor (V)): ");
            rol = Input.scanner.nextLine().toUpperCase();

            rolValido = validarRol(rol);
        } while (!rolValido);

        Usuario usuario = new Usuario(user, pass, rol);

        DataManager.agregarUsuario(usuario);
        System.out.println("Usuario registrado exitosamente!");
    }

    public static boolean validarRol(String rol) {
        rol = rol.trim();
        if (!rol.equalsIgnoreCase("M") && !rol.equalsIgnoreCase("V")) {
            System.out.println("Rol no válido. Por favor, ingrese ' (M) Microempresario' o ' (V) Vendedor'.");
            return false;
        }

        return true;

    }
}
