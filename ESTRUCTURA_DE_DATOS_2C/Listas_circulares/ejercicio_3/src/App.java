import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Planificador planificador = new Planificador();
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n====== Planificador Round Robin ======");
            System.out.println("1. Agregar proceso");
            System.out.println("2. Ejecutar planificador");
            System.out.println("3. Ver procesos en cola");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del proceso: ");
                String nombre = scanner.nextLine();
                System.out.print("PID: ");
                int pid = scanner.nextInt();
                System.out.print("Tiempo total (ms): ");
                int tiempo_restante = scanner.nextInt();
                System.out.print("Prioridad (1 al 3): ");
                int prioridad = scanner.nextInt();
                scanner.nextLine();
                planificador.agregar_proceso(nombre, pid, tiempo_restante, prioridad);

            } else if (opcion == 2) {
                System.out.print("Ingresa el quantum (ms): ");
                int quantum = scanner.nextInt();
                scanner.nextLine();
                planificador.ejecutar(quantum);

            } else if (opcion == 3) {
                planificador.mostrar_procesos();

            } else if (opcion == 4) {
                System.out.println("Cerrando el planificador.");

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}