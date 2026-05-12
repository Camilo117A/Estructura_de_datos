public class PilaPiezas {
    private Pieza tope;

    public PilaPiezas() {
        this.tope = null;
    }

    public void push(Pieza pieza) {
        pieza.siguiente = tope;
        tope = pieza;
    }

    public Pieza pop() {
        if (isEmpty()) return null;
        Pieza temp = tope;
        tope = tope.siguiente;
        temp.siguiente = null;
        return temp;
    }

    public Pieza peek() {
        return tope;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void limpiarHastaDefecto() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        boolean encontrado = false;
        while (!isEmpty()) {
            Pieza p = pop();
            if (p.esDefectuosa) {
                System.out.println(">>> PIEZA DEFECTUOSA: " + p.nombrePieza + " [" + p.numeroSerie + "] — LÍNEA DETENIDA <<<");
                encontrado = true;
                break;
            } else {
                System.out.println("Pieza buena retirada y descartada: " + p.nombrePieza + " [" + p.numeroSerie + "]");
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna pieza defectuosa en la pila.");
        }
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        Pieza actual = tope;
        System.out.print("TOPE -> ");
        while (actual != null) {
            System.out.print("[" + actual.nombrePieza + " | " + (actual.esDefectuosa ? "DEFECTUOSA" : "OK") + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> BASE");
    }
}