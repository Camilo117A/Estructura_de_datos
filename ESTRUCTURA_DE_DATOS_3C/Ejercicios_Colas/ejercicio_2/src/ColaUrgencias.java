public class ColaUrgencias {

    private Paciente salida;
    private Paciente entrada;

    public ColaUrgencias() {
        salida = null;
        entrada = null;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public void enqueue(Paciente nuevo) {
        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
    }

    public Paciente dequeue() {
        if (isEmpty()) return null;
        Paciente atendido = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        return atendido;
    }

    public void atenderTodos() {
        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        int totalAtendidos = 0;
        System.out.println("\n--- Inicio de atencion de turno ---");
        while (!isEmpty()) {
            Paciente p = dequeue();
            totalAtendidos++;
            System.out.println("\nPaciente #" + totalAtendidos);
            System.out.println("  Cedula  : " + p.cedula);
            System.out.println("  Nombre  : " + p.nombreCompleto);
            System.out.println("  Edad    : " + p.edad + " anios");
            System.out.println("  Sintoma : " + p.sintomaPrincipal);
        }
        System.out.println("\nTotal de pacientes atendidos en este turno: " + totalAtendidos);
    }

    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("La sala de espera esta vacia.");
            return;
        }
        System.out.print("SALIDA -> ");
        Paciente aux = salida;
        while (aux != null) {
            System.out.print("[" + aux.nombreCompleto + " | " + aux.sintomaPrincipal + "]");
            if (aux.siguiente != null) System.out.print(" -> ");
            aux = aux.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }
}
