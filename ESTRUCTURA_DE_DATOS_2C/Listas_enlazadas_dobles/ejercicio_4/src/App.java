public class App {

    public static void main(String[] args) {

        Consultorio consultorio = new Consultorio();

        consultorio.agregar_paciente("Carlos Perez",  35, 2);
        consultorio.agregar_paciente("Laura Gomez",   72, 3);
        consultorio.agregar_paciente("Pedro Ramirez", 58, 1);
        consultorio.agregar_paciente("Ana Torres",    45, 2);

        System.out.println();
        consultorio.mostrar_fila();

        System.out.println("\n-- Llega un paciente de emergencia --");
        consultorio.agregar_paciente("Juan Lopez", 80, 5);

        System.out.println();
        consultorio.mostrar_fila();

        System.out.println("\n-- Llega otra emergencia --");
        consultorio.agregar_paciente("Sofia Diaz", 67, 5);

        System.out.println();
        consultorio.mostrar_fila();

        System.out.println("\n-- Buscando el paciente de mayor edad desde la cola --");
        consultorio.paciente_mayor_edad();
    }
}