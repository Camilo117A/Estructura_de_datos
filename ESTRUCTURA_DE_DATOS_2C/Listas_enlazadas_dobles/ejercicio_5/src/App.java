import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Reproductor reproductor = new Reproductor();
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n====== Reproductor de Musica ======");
            System.out.println("1. Agregar cancion");
            System.out.println("2. Cancion siguiente");
            System.out.println("3. Cancion anterior");
            System.out.println("4. Ver cancion actual");
            System.out.println("5. Salir");
            System.out.println("6. Ver playlist completa");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Titulo de la cancion: ");
                String titulo = scanner.nextLine();
                System.out.print("Artista: ");
                String artista = scanner.nextLine();
                System.out.print("Duracion en segundos: ");
                int duracion = scanner.nextInt();
                scanner.nextLine();
                reproductor.agregar_cancion(titulo, artista, duracion);

            } else if (opcion == 2) {
                reproductor.saltar_adelante();

            } else if (opcion == 3) {
                reproductor.saltar_atras();

            } else if (opcion == 4) {
                reproductor.mostrar_cancion_actual();

            } else if (opcion == 5) {
                System.out.println("Cerrando el reproductor.");

            } else if (opcion == 6) {
                reproductor.mostrar_playlist();

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}