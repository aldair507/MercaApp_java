package Producto;

import Interfaces.IProducto;

public class Producto implements IProducto {
    private final String id;
    private String nombre;
    private int cantidad;
    private double precio;
    private double descuento;

    // Constructor
    public Producto(String id, String nombre, int cantidad, double precio, double descuento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;

    }

    // Métodos de la interfaz
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return String.format("%s - %s | Stock: %d | Precio: $%.2f  | Descuento: %.2f%%",
                id, nombre, cantidad, precio, descuento);
    }
}
