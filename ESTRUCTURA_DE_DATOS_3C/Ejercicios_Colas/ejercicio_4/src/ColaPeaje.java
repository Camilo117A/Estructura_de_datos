public class ColaPeaje {

    private Vehiculo salida;
    private Vehiculo entrada;

    public ColaPeaje() {
        salida = null;
        entrada = null;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public void enqueue(Vehiculo nuevo) {
        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
    }

    public Vehiculo dequeue() {
        if (isEmpty()) return null;
        Vehiculo cobrado = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        return cobrado;
    }

    public void cerrarTurno() {
        if (isEmpty()) {
            System.out.println("No hay vehiculos en el carril.");
            return;
        }
        double totalRecaudado = 0;
        int totalVehiculos = 0;
        int exentos = 0;
        System.out.println("\n--- Cerrando turno ---");
        while (!isEmpty()) {
            Vehiculo v = dequeue();
            totalVehiculos++;
            if (!v.esExento) {
                totalRecaudado += v.tarifa;
                System.out.println("Cobrado: " + v.placa + " (" + v.tipoVehiculo + ") -> $" + v.tarifa);
            } else {
                exentos++;
                System.out.println("Exento : " + v.placa + " (" + v.tipoVehiculo + ") -> sin cobro");
            }
        }
        System.out.println("\nResumen del turno:");
        System.out.println("  Vehiculos procesados : " + totalVehiculos);
        System.out.println("  Vehiculos exentos    : " + exentos);
        System.out.println("  Total recaudado      : $" + String.format("%.2f", totalRecaudado));
    }

    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("El carril esta vacio.");
            return;
        }
        System.out.print("SALIDA -> ");
        Vehiculo aux = salida;
        while (aux != null) {
            System.out.print("[" + aux.placa + " | " + aux.tipoVehiculo + "]");
            if (aux.siguiente != null) System.out.print(" -> ");
            aux = aux.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }
}
