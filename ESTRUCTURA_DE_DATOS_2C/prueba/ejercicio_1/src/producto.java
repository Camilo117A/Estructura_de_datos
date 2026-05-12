public class producto {
    String codigo;
    String Nombre;
    int Cantidad;
    float precio;

    producto Siguiente;

    public producto(String codigo, String Nombre, int Cantidad, float precio) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.Siguiente = null;
    }
}
