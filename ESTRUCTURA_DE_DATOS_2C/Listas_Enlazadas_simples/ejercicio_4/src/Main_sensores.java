import java.util.Scanner;

public class Main_sensores {
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        Historial_sensores Planta = new Historial_sensores();
        int Opcion = 0;

        while (Opcion != 4) {
            System.out.println("\n--- MENÚ MONITOREO INDUSTRIAL ---");
            System.out.println("1. Registrar lectura de sensor");
            System.out.println("2. Mostrar historial");
            System.out.println("3. Buscar temperatura más alta");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            Opcion = Lector.nextInt();
            Lector.nextLine();

            if (Opcion == 1) {
                System.out.print("ID del sensor: ");
                int Id_sensor = Lector.nextInt();
                System.out.print("Temperatura (°C): ");
                double Temperatura = Lector.nextDouble();
                System.out.print("Presión (bar): ");
                double Presion = Lector.nextDouble();
                Lector.nextLine();
                System.out.print("Hora (ej: 08:00): ");
                String Hora = Lector.nextLine();
                Planta.registrarLectura(new Lectura(Id_sensor, Temperatura, Presion, Hora));

            } else if (Opcion == 2) {
                Planta.mostrarHistorial();

            } else if (Opcion == 3) {
                Planta.buscarTemp_mas_alta();

            } else if (Opcion != 4) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Hasta luego!");
        Lector.close();
    }
}
