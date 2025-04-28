package Persona;

import java.util.Date;

public abstract class Persona {

    protected int idPersona;
    protected String rol; // Rol de la persona (Vendedor, Microempresario, Administrador)
    protected boolean estadoPersona;
    protected Date fechaCreacionPersona;
    // Atributos comunes a todas las personas
    protected String nombrePersona;
    protected String apellido;
    protected int edad;
    protected int dni;
    protected String correo;

    public Persona(int idPersona, String rol, boolean estadoPersona, Date fechaCreacionPersona, String nombrePersona,
            String apellido, int edad, int dni, String correo) {
        this.idPersona = idPersona;
        this.rol = rol;
        this.estadoPersona = estadoPersona;
        this.fechaCreacionPersona = fechaCreacionPersona;

        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.correo = correo;
    }

    public abstract void mostrarInformacion(); // Método abstracto para mostrar información de la persona

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(boolean estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public Date getFechaCreacionPersona() {
        return fechaCreacionPersona;
    }

    public void setFechaCreacionPersona(Date fechaCreacionPersona) {
        this.fechaCreacionPersona = fechaCreacionPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
