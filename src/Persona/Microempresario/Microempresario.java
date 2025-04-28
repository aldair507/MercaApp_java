package Persona.Microempresario;

import Interfaces.IUsuario;
import Persona.Persona;

public class Microempresario extends Persona implements IUsuario {

    private final int idUsuario;
    private String username;
    private final String password;
    private String rol;

    // Constructor
    public Microempresario(String username, String password, int idUsuario, String rol) {
        super(idUsuario, rol, true, null, null, null, 0, 0, null); 
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = "Microempresario";
    }

    // Implementación de métodos de IUsuario
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String getRol() {
        return rol;
    }

    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    // Implementación del método abstracto de Persona
    @Override
    public void mostrarInformacion() {
        System.out.println("Microempresario: " + username);
        System.out.println("ID: " + idUsuario);
        System.out.println("Rol: " + rol);
    }
}
