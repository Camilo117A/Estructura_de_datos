import java.util.Scanner;

public class Main_vuelos {
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        Cola_Vuelos Torre = new Cola_Vuelos();
        int Opcion = 0;

        while (Opcion != 4) {
            System.out.println("\n--- MENU TORRE DE CONTROL ---");
            System.out.println("1. Agregar vuelo a la cola");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar cola de aterrizaje");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            Opcion = Lector.nextInt();
            Lector.nextLine();

            if (Opcion == 1) {
                System.out.print("Numero de vuelo: ");
                String Numero_vuelo = Lector.nextLine();
                System.out.print("Aerolinea: ");
                String Aerolinea = Lector.nextLine();
                System.out.print("Combustible restante: ");
                int Combustible_restante = Lector.nextInt();
                System.out.print("Numero de pasajeros: ");
                int Pasajeros = Lector.nextInt();
                Lector.nextLine();
                Torre.agregarVuelo(new Vuelos(Numero_vuelo, Aerolinea, Combustible_restante, Pasajeros));

            } else if (Opcion == 2) {
                System.out.print("Numero de vuelo en emergencia: ");
                String Numero_vuelo = Lector.nextLine();
                Torre.reportarEmergencia(Numero_vuelo);

            } else if (Opcion == 3) {
                Torre.mostrarCola();

            } else if (Opcion != 4) {
                System.out.println("Opcion no valida.");
            }
        }
        System.out.println("Hasta luego.");
        Lector.close();
    }
}
