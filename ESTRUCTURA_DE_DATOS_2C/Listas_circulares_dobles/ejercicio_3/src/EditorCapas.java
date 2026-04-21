
public class EditorCapas {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public EditorCapas() {
        this.cabeza     = null;
        this.cola       = null;
        this.capaActiva = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarCapa(String nombre, boolean visible, String tipo) {
        Capa nueva = new Capa(nombre, visible, tipo);
        if (cabeza == null) {
            nueva.siguiente = nueva;
            nueva.anterior  = nueva;
            cabeza     = nueva;
            cola       = nueva;
            capaActiva = nueva;
        } else {
            cola.siguiente  = nueva;
            nueva.anterior  = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    public void subirCapa() {
        if (estaVacio()) {
            System.out.println("  [Sin capas]");
            return;
        }
        capaActiva = capaActiva.siguiente;
        System.out.println("  [Subir] Capa activa: " + capaActiva.nombre);
    }

    public void bajarCapa() {
        if (estaVacio()) {
            System.out.println("  [Sin capas]");
            return;
        }
        capaActiva = capaActiva.anterior;
        System.out.println("  [Bajar] Capa activa: " + capaActiva.nombre);
    }

    public void toggleVisibilidad() {
        if (estaVacio()) {
            System.out.println("  [Sin capas]");
            return;
        }
        capaActiva.visible = !capaActiva.visible;
        System.out.println("  [Visibilidad] \"" + capaActiva.nombre + "\" ahora es: "
                + (capaActiva.visible ? "VISIBLE" : "OCULTA"));
    }

    public void eliminarActiva() {
        if (estaVacio()) {
            System.out.println("  [Sin capas que eliminar]");
            return;
        }
        System.out.println("  [Eliminando capa] \"" + capaActiva.nombre + "\"");

        if (capaActiva.siguiente == capaActiva) {
            cabeza     = null;
            cola       = null;
            capaActiva = null;
            return;
        }

        Capa aEliminar = capaActiva;

        capaActiva = aEliminar.siguiente;

        aEliminar.anterior.siguiente = aEliminar.siguiente;
        aEliminar.siguiente.anterior = aEliminar.anterior;

        if (aEliminar == cabeza) cabeza = aEliminar.siguiente;
        if (aEliminar == cola)   cola   = aEliminar.anterior;
    }

    public void mostrarCapas() {
        if (estaVacio()) {
            System.out.println("  [Sin capas en el editor]");
            return;
        }
        System.out.println("  === Capas del Editor (de arriba hacia abajo) ===");
        Capa actual = cabeza;
        int numero = 1;
        do {
            String activa  = (actual == capaActiva) ? " ACTIVA" : "      ";
            String visib   = actual.visible ? "[VIS]" : "[OC] ";
            System.out.println("  " + numero + ". " + visib + " \"" + actual.nombre + "\"" + "  Tipo: " + actual.tipo + activa);
            actual = actual.siguiente;
            numero++;
        } while (actual != cabeza);
        System.out.println("  (circular → regresa a \"" + cabeza.nombre + "\")");
    }
}
