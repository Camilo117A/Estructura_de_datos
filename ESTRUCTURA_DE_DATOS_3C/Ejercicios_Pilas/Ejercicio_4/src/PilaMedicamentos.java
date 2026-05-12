public class PilaMedicamentos {
    private Medicamento tope;

    public PilaMedicamentos() {
        this.tope = null;
    }

    public void push(Medicamento medicamento) {
        medicamento.siguiente = tope;
        tope = medicamento;
    }

    public Medicamento pop() {
        if (isEmpty()) return null;
        Medicamento temp = tope;
        tope = tope.siguiente;
        temp.siguiente = null;
        return temp;
    }

    public Medicamento peek() {
        return tope;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void validarDespacho() {
        if (isEmpty()) {
            System.out.println("El dispensador está vacío. No hay medicamentos para despachar.");
            return;
        }

        while (!isEmpty()) {
            Medicamento m = peek();
            if (m.diasParaVencer < 10) {
                pop();
                System.out.println("RETIRADO POR VENCIMIENTO: " + m.nombre + " | Lote: " + m.lote + " | Días restantes: " + m.diasParaVencer);
            } else {
                System.out.println("Medicamento listo para despachar: " + m.nombre + " | Lote: " + m.lote + " | Días para vencer: " + m.diasParaVencer);
                return;
            }
        }

        System.out.println("No quedan medicamentos aptos en el dispensador.");
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("El dispensador está vacío.");
            return;
        }
        Medicamento actual = tope;
        System.out.print("TOPE -> ");
        while (actual != null) {
            System.out.print("[" + actual.nombre + " | Lote: " + actual.lote + " | " + actual.diasParaVencer + " días]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> BASE");
    }
}
