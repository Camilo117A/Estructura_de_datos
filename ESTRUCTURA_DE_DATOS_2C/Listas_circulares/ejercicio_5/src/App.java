import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n====== Torneo de Futbol ======");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Generar fixture completo");
            System.out.println("3. Ver equipos registrados");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del equipo: ");
                String nombre = scanner.nextLine();
                System.out.print("Ciudad: ");
                String ciudad = scanner.nextLine();
                System.out.print("Puntos iniciales: ");
                int puntos = scanner.nextInt();
                System.out.print("Goles a favor: ");
                int goles_favor = scanner.nextInt();
                scanner.nextLine();
                torneo.agregar_equipo(nombre, ciudad, puntos, goles_favor);

            } else if (opcion == 2) {
                torneo.generar_fixture();

            } else if (opcion == 3) {
                torneo.mostrar_equipos();

            } else if (opcion == 4) {
                System.out.println("Cerrando el sistema del torneo.");

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}