public class Galeria {

    Fotografia cabeza;
    Fotografia cola;
    Fotografia actual;

    public Galeria() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public void agregar_foto(String nombre_archivo, double tamano_mb, String resolucion) {
        Fotografia nueva = new Fotografia(nombre_archivo, tamano_mb, resolucion);

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            nueva.anterior = cola;
            cola.siguiente = nueva;
            cola = nueva;
        }
        System.out.println("Foto agregada: " + nombre_archivo);
    }

    public void siguiente_foto() {
        if (actual == null) {
            System.out.println("La galeria esta vacia.");
            return;
        }
        if (actual.siguiente == null) {
            System.out.println("Ya estas en la ultima foto, no puedes avanzar mas.");
            return;
        }
        actual = actual.siguiente;
        mostrar_foto_actual();
    }

    public void foto_anterior() {
        if (actual == null) {
            System.out.println("La galeria esta vacia.");
            return;
        }
        if (actual.anterior == null) {
            System.out.println("Ya estas en la primera foto, no puedes retroceder mas.");
            return;
        }
        actual = actual.anterior;
        mostrar_foto_actual();
    }

    public void mostrar_foto_actual() {
        if (actual == null) {
            System.out.println("No hay foto seleccionada.");
            return;
        }
        System.out.println("Foto actual -> Archivo: " + actual.nombre_archivo
                + " | Tamano: " + actual.tamano_mb + " MB"
                + " | Resolucion: " + actual.resolucion);
    }

    public void reproducir_galeria() {
        if (cabeza == null) {
            System.out.println("La galeria esta vacia.");
            return;
        }

        System.out.println("====== Reproduciendo hacia ADELANTE ======");
        Fotografia temp = cabeza;
        while (temp != null) {
            System.out.println("  -> " + temp.nombre_archivo
                    + " | " + temp.tamano_mb + " MB"
                    + " | " + temp.resolucion);
            temp = temp.siguiente;
        }

        System.out.println("====== Reproduciendo hacia ATRAS ======");
        temp = cola;
        while (temp != null) {
            System.out.println("  <- " + temp.nombre_archivo
                    + " | " + temp.tamano_mb + " MB"
                    + " | " + temp.resolucion);
            temp = temp.anterior;
        }
    }
}