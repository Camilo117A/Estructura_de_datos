public class PilaEstaciones {
    private Estacion tope;

    public PilaEstaciones() {
        this.tope = null;
    }

    public void push(Estacion estacion) {
        estacion.siguiente = tope;
        tope = estacion;
    }

    public Estacion pop() {
        if (isEmpty()) return null;
        Estacion temp = tope;
        tope = tope.siguiente;
        temp.siguiente = null;
        return temp;
    }

    public Estacion peek() {
        return tope;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void retrocederASuperficie() {
        if (isEmpty()) {
            System.out.println("No hay estaciones registradas. El equipo ya está en la superficie.");
            return;
        }

        System.out.println("\n--- INICIANDO RETROCESO A LA SUPERFICIE ---");

        while (!isEmpty()) {
            Estacion e = pop();
            System.out.println("Pasando por: " + e.nombrePunto + " | Profundidad: " + e.profundidad + "m | Oxígeno: " + e.nivelOxigeno + "%");
            if (e.nivelOxigeno < 18.0) {
                System.out.println("  *** ALERTA: USO DE TANQUE DE EMERGENCIA REQUERIDO ***");
            }
        }

        System.out.println("--- EQUIPO EN SUPERFICIE. RETROCESO COMPLETADO ---");
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("No hay estaciones registradas.");
            return;
        }
        Estacion actual = tope;
        System.out.print("TOPE -> ");
        while (actual != null) {
            System.out.print("[" + actual.nombrePunto + " | " + actual.profundidad + "m | O2: " + actual.nivelOxigeno + "%]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> BASE");
    }
}
