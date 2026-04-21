
public class HistorialTerminal {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public HistorialTerminal() {
        this.cabeza = null;
        this.cola   = null;
        this.cursor = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregar(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);
        if (cabeza == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior  = nuevo;
            cabeza = nuevo;
            cola   = nuevo;
        } else {
            cola.siguiente  = nuevo;
            nuevo.anterior  = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }

        cursor = cola;
    }

    public void arriba() {
        if (estaVacio()) {
            System.out.println("  [Historial vacío]");
            return;
        }
        cursor = cursor.anterior;
        System.out.println("  [Arriba] Comando actual: " + cursor.texto);
    }

    public void abajo() {
        if (estaVacio()) {
            System.out.println("  [Historial vacío]");
            return;
        }
        cursor = cursor.siguiente;
        System.out.println("  [Abajo] Comando actual: " + cursor.texto);
    }

    public void mostrarCursor() {
        if (estaVacio()) {
            System.out.println("  [Historial vacío]");
            return;
        }
        System.out.println("  [Cursor] → \"" + cursor.texto + "\"" + "  |  Exitoso: " + (cursor.exitoso ? "Sí" : "No") + "  |  Dir: " + cursor.directorio);
    }

    public void eliminarActual() {
        if (estaVacio()) {
            System.out.println("  [Historial vacío, nada que eliminar]");
            return;
        }
        System.out.println("  [Eliminando] \"" + cursor.texto + "\"");

        if (cursor.siguiente == cursor) {
            cabeza  = null;
            cola    = null;
            cursor  = null;
            return;
        }

        Comando aEliminar = cursor;

        cursor = aEliminar.siguiente;

        aEliminar.anterior.siguiente = aEliminar.siguiente;
        aEliminar.siguiente.anterior = aEliminar.anterior;

        if (aEliminar == cabeza) cabeza = aEliminar.siguiente;
        if (aEliminar == cola)   cola   = aEliminar.anterior;
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("  [Historial vacío]");
            return;
        }
        System.out.println("  === Historial completo (más antiguo → más reciente) ===");
        Comando actual = cabeza;
        int numero = 1;
        do {
            String marca   = (actual == cursor) ? "CURSOR" : "";
            String estado  = actual.exitoso ? "[OK]" : "[ERR]";
            System.out.println("  " + numero + ". " + estado + " \"" + actual.texto + "\"" + "  en " + actual.directorio + marca);
            actual = actual.siguiente;
            numero++;
        } while (actual != cabeza);
        System.out.println("  (circular → regresa a \"" + cabeza.texto + "\")");
    }
}
