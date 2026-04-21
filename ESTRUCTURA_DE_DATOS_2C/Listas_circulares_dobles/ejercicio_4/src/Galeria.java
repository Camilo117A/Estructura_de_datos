
public class Galeria {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public Galeria() {
        this.cabeza = null;
        this.cola   = null;
        this.actual = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha, boolean esFavorita) {
        Foto nueva = new Foto(titulo, fecha, esFavorita);
        if (cabeza == null) {
            nueva.siguiente = nueva;
            nueva.anterior  = nueva;
            cabeza = nueva;
            cola   = nueva;
            actual = nueva;
        } else {
            cola.siguiente  = nueva;
            nueva.anterior  = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    public void siguiente() {
        if (estaVacia()) {
            System.out.println("  [Galería vacía]");
            return;
        }
        actual = actual.siguiente;
        System.out.println("  [→ Siguiente] Viendo: \"" + actual.titulo + "\"");
    }

    public void anterior() {
        if (estaVacia()) {
            System.out.println("  [Galería vacía]");
            return;
        }
        actual = actual.anterior;
        System.out.println("  [← Anterior] Viendo: \"" + actual.titulo + "\"");
    }

    public void toggleFavorita() {
        if (estaVacia()) {
            System.out.println("  [Galería vacía]");
            return;
        }
        actual.esFavorita = !actual.esFavorita;
        System.out.println("  [★ Favorita] \"" + actual.titulo + "\" → "
                + (actual.esFavorita ? "marcada como FAVORITA" : "quitada de favoritas"));
    }

    public void eliminarActual() {
        if (estaVacia()) {
            System.out.println("  [Galería vacía, nada que eliminar]");
            return;
        }
        System.out.println("  [Eliminando] \"" + actual.titulo + "\"");

        if (actual.siguiente == actual) {
            cabeza = null;
            cola   = null;
            actual = null;
            return;
        }

        Foto aEliminar = actual;

        actual = aEliminar.siguiente;

        aEliminar.anterior.siguiente = aEliminar.siguiente;
        aEliminar.siguiente.anterior = aEliminar.anterior;

        if (aEliminar == cabeza) cabeza = aEliminar.siguiente;
        if (aEliminar == cola)   cola   = aEliminar.anterior;
    }

    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("  [Galería vacía]");
            return;
        }
        System.out.println("  === Álbum de Fotos ===");
        Foto foto = cabeza;
        int numero = 1;
        do {
            String visor    = (foto == actual)      ? " [>]" : "     ";
            String favorita = foto.esFavorita       ? " [*]" : "     ";
            System.out.println("  " + numero + "." + visor + favorita + " \"" + foto.titulo + "\"" + "  (" + foto.fecha + ")");
            foto = foto.siguiente;
            numero++;
        } while (foto != cabeza);
        System.out.println("  (circular → regresa a \"" + cabeza.titulo + "\")");
    }
}
