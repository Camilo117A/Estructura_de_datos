public class Reproductor {

    Cancion cabeza;
    Cancion cola;
    Cancion actual;

    public Reproductor() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public void agregar_cancion(String titulo, String artista, int duracion) {
        Cancion nueva = new Cancion(titulo, artista, duracion);

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            nueva.anterior = cola;
            cola.siguiente = nueva;
            cola = nueva;
        }
        System.out.println("Cancion agregada: " + titulo + " - " + artista);
    }

    public void saltar_adelante() {
        if (actual == null) {
            System.out.println("La playlist esta vacia.");
            return;
        }
        if (actual.siguiente == null) {
            System.out.println("Ya estas en la ultima cancion, no hay siguiente.");
            return;
        }
        actual = actual.siguiente;
        mostrar_cancion_actual();
    }

    public void saltar_atras() {
        if (actual == null) {
            System.out.println("La playlist esta vacia.");
            return;
        }
        if (actual.anterior == null) {
            System.out.println("Error: ya estas en la primera cancion, no puedes retroceder mas.");
            return;
        }
        actual = actual.anterior;
        mostrar_cancion_actual();
    }

    public void mostrar_cancion_actual() {
        if (actual == null) {
            System.out.println("No hay ninguna cancion reproduciendose.");
            return;
        }
        int minutos = actual.duracion / 60;
        int segundos = actual.duracion % 60;
        System.out.println("Reproduciendo -> \"" + actual.titulo + "\""
                + " | Artista: " + actual.artista
                + " | Duracion: " + minutos + ":" + String.format("%02d", segundos));
    }

    public void mostrar_playlist() {
        if (cabeza == null) {
            System.out.println("La playlist esta vacia.");
            return;
        }
        Cancion temp = cabeza;
        int numero = 1;
        System.out.println("====== Playlist ======");
        while (temp != null) {
            int min = temp.duracion / 60;
            int seg = temp.duracion % 60;
            if (temp == actual) {
                System.out.println("  " + numero + ". \"" + temp.titulo + "\" - " + temp.artista
                        + " (" + min + ":" + String.format("%02d", seg) + ")  <- REPRODUCIENDO");
            } else {
                System.out.println("  " + numero + ". \"" + temp.titulo + "\" - " + temp.artista
                        + " (" + min + ":" + String.format("%02d", seg) + ")");
            }
            numero++;
            temp = temp.siguiente;
        }
        System.out.println("======================");
    }
}