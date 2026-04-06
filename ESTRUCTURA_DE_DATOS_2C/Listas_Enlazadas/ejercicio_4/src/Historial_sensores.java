public class Historial_sensores {
    Lectura Cabeza;

    public Historial_sensores() {
        this.Cabeza = null;
    }

    public void registrarLectura(Lectura Nueva_lectura) {
        Nueva_lectura.Siguiente = Cabeza;
        Cabeza = Nueva_lectura;
        System.out.println("Lectura registrada - Sensor " + Nueva_lectura.Id_sensor + " a las " + Nueva_lectura.Hora);
    }

    public void buscarTemp_mas_alta() {
        if (Cabeza == null) {
            System.out.println("No hay lecturas registradas.");
            return;
        }
        Lectura Actual = Cabeza;
        Lectura Lectura_max = Cabeza;
        while (Actual != null) {
            if (Actual.Temperatura > Lectura_max.Temperatura) {
                Lectura_max = Actual;
            }
            Actual = Actual.Siguiente;
        }
        System.out.println("\nTemperatura más alta registrada:");
        System.out.println("Sensor: " + Lectura_max.Id_sensor + " | Temperatura: " + Lectura_max.Temperatura + "°C | Presión: " + Lectura_max.Presion + " bar | Hora: " + Lectura_max.Hora);
    }

    public void mostrarHistorial() {
        System.out.println("\nHistorial de lecturas (más reciente primero):");
        Lectura Actual = Cabeza;
        while (Actual != null) {
            System.out.println("[Sensor " + Actual.Id_sensor + " | " + Actual.Temperatura + "°C | " + Actual.Presion + " bar | " + Actual.Hora + "]");
            Actual = Actual.Siguiente;
        }
    }
}
