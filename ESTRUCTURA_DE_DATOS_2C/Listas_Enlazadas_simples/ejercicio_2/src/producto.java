public class producto {
    String Nombre;
    int Cantidad;
    int Dias_para_vencer;
    producto Siguiente;

    public producto(String Nombre, int Cantidad, int Dias_para_vencer) {
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.Dias_para_vencer = Dias_para_vencer;
        this.Siguiente = null;
    }
}
