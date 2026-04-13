public class Consultorio {

    Paciente cabeza;
    Paciente cola;

    public Consultorio() {
        cabeza = null;
        cola = null;
    }

    public void agregar_paciente(String nombre, int edad, int nivel_urgencia) {
        Paciente nuevo = new Paciente(nombre, edad, nivel_urgencia);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            System.out.println("Paciente agregado (primero): " + nombre);
            return;
        }

        if (nivel_urgencia == 5) {
            if (cabeza == cola) {
                nuevo.anterior = cabeza;
                cabeza.siguiente = nuevo;
                cola = nuevo;
            } else {
                nuevo.siguiente = cabeza.siguiente;
                nuevo.anterior = cabeza;
                cabeza.siguiente.anterior = nuevo;
                cabeza.siguiente = nuevo;
            }
            System.out.println("EMERGENCIA - Paciente insertado al frente: " + nombre);
            return;
        }

        nuevo.anterior = cola;
        cola.siguiente = nuevo;
        cola = nuevo;
        System.out.println("Paciente agregado al final: " + nombre);
    }

    public void paciente_mayor_edad() {
        if (cola == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }

        Paciente temp = cola;
        Paciente mayor = cola;

        while (temp != null) {
            if (temp.edad > mayor.edad) {
                mayor = temp;
            }
            temp = temp.anterior;
        }

        System.out.println("====== Paciente de mayor edad ======");
        System.out.println("  Nombre         : " + mayor.nombre);
        System.out.println("  Edad           : " + mayor.edad + " anios");
        System.out.println("  Nivel urgencia : " + mayor.nivel_urgencia);
        System.out.println("====================================");
    }

    public void mostrar_fila() {
        if (cabeza == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        Paciente temp = cabeza;
        int turno = 1;
        System.out.println("====== Fila de Pacientes ======");
        while (temp != null) {
            System.out.println("  Turno " + turno + " -> " + temp.nombre
                    + " | Edad: " + temp.edad
                    + " | Urgencia: " + temp.nivel_urgencia);
            turno++;
            temp = temp.siguiente;
        }
        System.out.println("================================");
    }
}