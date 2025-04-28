package Interfaces;

public interface IProducto {

    String getId();
    String getNombre();
    int getCantidad();
    double getPrecio();
    void setCantidad(int cantidad);
    void setNombre(String nombre);
    void setPrecio(double precio);
    // // Métodos agregados
    // void actualizarStock(int cambioCantidad);
}
