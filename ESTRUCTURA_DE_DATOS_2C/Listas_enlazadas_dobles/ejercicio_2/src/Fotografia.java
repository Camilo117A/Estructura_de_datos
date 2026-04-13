public class Fotografia {

    String nombre_archivo;
    double tamano_mb;
    String resolucion;
    Fotografia siguiente;
    Fotografia anterior;

    public Fotografia(String nombre_archivo, double tamano_mb, String resolucion) {
        this.nombre_archivo = nombre_archivo;
        this.tamano_mb = tamano_mb;
        this.resolucion = resolucion;
        this.siguiente = null;
        this.anterior = null;
    }
}