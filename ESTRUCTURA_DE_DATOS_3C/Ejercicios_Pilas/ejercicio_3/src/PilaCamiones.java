public class PilaCamiones {
    private Camion tope;

    public PilaCamiones() {
        this.tope = null;
    }

    public void push(Camion camion) {
        camion.siguiente = tope;
        tope = camion;
    }

    public Camion pop() {
        if (isEmpty()) return null;
        Camion temp = tope;
        tope = tope.siguiente;
        temp.siguiente = null;
        return temp;
    }

    public Camion peek() {
        return tope;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public double calcularCargaTotal() {
        double total = 0;
        PilaCamiones auxiliar = new PilaCamiones();

        while (!isEmpty()) {
            Camion c = pop();
            total += c.cargaToneladas;
            auxiliar.push(c);
        }

        while (!auxiliar.isEmpty()) {
            push(auxiliar.pop());
        }

        return total;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("El callejón está vacío.");
            return;
        }
        Camion actual = tope;
        System.out.print("TOPE -> ");
        while (actual != null) {
            System.out.print("[" + actual.placa + " | " + actual.conductor + " | " + actual.cargaToneladas + "t]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> BASE");
    }
}
