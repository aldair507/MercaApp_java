package Interfaces;

public interface IUsuario {
    String getUsername();
    int getIdUsuario();
    String getPassword();
    String getRol();
    void setUsername(String username);
    void setRol(String rol);
}
