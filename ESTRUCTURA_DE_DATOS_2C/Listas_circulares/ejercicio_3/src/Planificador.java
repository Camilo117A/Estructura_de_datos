public class Planificador {

    Proceso cabeza;
    Proceso cola;
    int cantidad;

    public Planificador() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    public void agregar_proceso(String nombre, int pid, int tiempo_restante, int prioridad) {
        Proceso nuevo = new Proceso(nombre, pid, tiempo_restante, prioridad);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
        cantidad++;
        System.out.println("Proceso agregado: " + nombre + " | PID: " + pid + " | Tiempo: " + tiempo_restante);
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        String orden_terminados = "";
        int numero_orden = 1;

        System.out.println("\n====== Iniciando planificador Round Robin | Quantum: " + quantum + " ======");

        Proceso actual = cabeza;
        Proceso anterior = cola;

        while (cantidad > 0) {

            System.out.println("\n  Ejecutando: " + actual.nombre
                    + " | PID: " + actual.pid
                    + " | Tiempo restante antes: " + actual.tiempo_restante);

            actual.tiempo_restante -= quantum;

            if (actual.tiempo_restante <= 0) {
                System.out.println("  -> Proceso " + actual.nombre + " TERMINO.");
                orden_terminados += numero_orden + ". " + actual.nombre + " (PID " + actual.pid + ")\n";
                numero_orden++;

                if (cantidad == 1) {
                    cabeza = null;
                    cola = null;
                    cantidad--;
                    break;
                }

                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                    actual = cabeza;
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                    actual = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                    actual = anterior.siguiente;
                }
                cantidad--;

            } else {
                System.out.println("  -> Tiempo restante despues: " + actual.tiempo_restante);
                anterior = actual;
                actual = actual.siguiente;
            }
        }

        System.out.println("\n====== Orden en que terminaron los procesos ======");
        System.out.print(orden_terminados);
        System.out.println("==================================================");
    }

    public void mostrar_procesos() {
        if (cabeza == null) {
            System.out.println("No hay procesos en la lista.");
            return;
        }
        Proceso temp = cabeza;
        System.out.println("====== Procesos en cola ======");
        do {
            System.out.println("  " + temp.nombre
                    + " | PID: " + temp.pid
                    + " | Tiempo restante: " + temp.tiempo_restante
                    + " | Prioridad: " + temp.prioridad);
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("==============================");
    }
}