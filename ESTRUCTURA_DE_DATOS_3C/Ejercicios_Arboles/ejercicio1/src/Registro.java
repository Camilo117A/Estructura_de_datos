public class Registro {

    double temperatura;
    String fecha;
    String estacion;
    double humedad;

    Registro izquierdo;
    Registro derecho;

    public Registro(double temperatura, String fecha, String estacion, double humedad) {
        this.temperatura = temperatura;
        this.fecha = fecha;
        this.estacion = estacion;
        this.humedad = humedad;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "[" + temperatura + "°C | " + fecha + " | " + estacion + " | Humedad: " + humedad + "%]";
    }
}