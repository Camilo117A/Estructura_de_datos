import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Consultorio consultorio = new Consultorio();
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n====== Consultorio Medico ======");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Ver fila de pacientes");
            System.out.println("3. Buscar paciente de mayor edad");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del paciente: ");
                String nombre = scanner.nextLine();
                System.out.print("Edad: ");
                int edad = scanner.nextInt();
                System.out.print("Nivel de urgencia (1 al 5): ");
                int nivel_urgencia = scanner.nextInt();
                scanner.nextLine();
                consultorio.agregar_paciente(nombre, edad, nivel_urgencia);

            } else if (opcion == 2) {
                consultorio.mostrar_fila();

            } else if (opcion == 3) {
                consultorio.paciente_mayor_edad();

            } else if (opcion == 4) {
                System.out.println("Cerrando el consultorio.");

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}