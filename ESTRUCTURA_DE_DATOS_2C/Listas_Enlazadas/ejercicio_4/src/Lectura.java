public class Lectura {
    int Id_sensor;
    double Temperatura;
    double Presion;
    String Hora;
    Lectura Siguiente;

    public Lectura(int Id_sensor, double Temperatura, double Presion, String Hora) {
        this.Id_sensor = Id_sensor;
        this.Temperatura = Temperatura;
        this.Presion = Presion;
        this.Hora = Hora;
        this.Siguiente = null;
    }
}
