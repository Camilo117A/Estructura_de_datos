public class Lista_reproduccion {
    Cancion Cabeza;
    Cancion Actual_reproduciendo;

    public Lista_reproduccion() {
        this.Cabeza = null;
        this.Actual_reproduciendo = null;
    }

    public void agregarAlFinal(Cancion Nueva_cancion) {
        if (Cabeza == null) {
            Cabeza = Nueva_cancion;
            Actual_reproduciendo = Cabeza;
        } else {
            Cancion Actual = Cabeza;
            while (Actual.Siguiente != null) {
                Actual = Actual.Siguiente;
            }
            Actual.Siguiente = Nueva_cancion;
        }
        System.out.println("Añadida al final: " + Nueva_cancion.Titulo);
    }

    public void agregarAContinuacion(Cancion Nueva_cancion) {
        if (Actual_reproduciendo == null) {
            Cabeza = Nueva_cancion;
            Actual_reproduciendo = Cabeza;
        } else {
            Nueva_cancion.Siguiente = Actual_reproduciendo.Siguiente;
            Actual_reproduciendo.Siguiente = Nueva_cancion;
        }
        System.out.println("Añadida a continuación: " + Nueva_cancion.Titulo);
    }

    public void mostrarTiempo_total() {
        int Tiempo_total = 0;
        Cancion Actual = Cabeza;
        while (Actual != null) {
            Tiempo_total += Actual.Duracion_segundos;
            Actual = Actual.Siguiente;
        }
        int Minutos = Tiempo_total / 60;
        int Segundos = Tiempo_total % 60;
        System.out.println("\nTiempo total de la lista: " + Minutos + ":" + (Segundos < 10 ? "0" : "") + Segundos);
    }

    public void mostrarLista() {
        System.out.println("\nLista de reproducción:");
        Cancion Actual = Cabeza;
        while (Actual != null) {
            System.out.println("[" + Actual.Titulo + " | " + Actual.Artista + " | " + Actual.Duracion_segundos + "s | " + Actual.Genero + "]");
            Actual = Actual.Siguiente;
        }
    }
}
