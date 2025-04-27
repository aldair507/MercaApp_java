package Persona;

import Data.DataManager;
import Utils.Input;

public class Registro {

    public static void registrarUsuario() {
        String user;
        String pass;
        String rol;

        System.out.println("=================== REGISTRO DE USUARIO =================");
        System.out.println("Por favor, complete los siguientes datos para registrarse.");
        System.out.print("Usuario: ");
        user = Input.scanner.nextLine();
        System.out.print("Contraseña: ");
        pass = Input.scanner.nextLine();
        System.out.print("Rol (Microempresario/Vendedor): ");
        rol = Input.scanner.nextLine();

        Usuario usuario = new Usuario(user, pass, rol);

        DataManager.agregarUsuario(usuario);
        System.out.println("Usuario registrado exitosamente!");
    }
}
