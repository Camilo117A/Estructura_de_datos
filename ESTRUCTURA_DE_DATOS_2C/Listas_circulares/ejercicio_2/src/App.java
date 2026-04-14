import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Carrusel carrusel = new Carrusel();
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n====== Carrusel de Anuncios ======");
            System.out.println("1. Agregar anuncio");
            System.out.println("2. Reproducir ciclos");
            System.out.println("3. Ver anuncios");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Titulo del anuncio: ");
                String titulo = scanner.nextLine();
                System.out.print("Duracion en segundos: ");
                int duracion_segundos = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Categoria (Oferta / Marca / Evento): ");
                String categoria = scanner.nextLine();
                carrusel.agregar_anuncio(titulo, duracion_segundos, categoria);

            } else if (opcion == 2) {
                System.out.print("Cuantos ciclos quieres reproducir: ");
                int ciclos = scanner.nextInt();
                scanner.nextLine();
                carrusel.reproducir(ciclos);

            } else if (opcion == 3) {
                carrusel.mostrar_anuncios();

            } else if (opcion == 4) {
                System.out.println("Apagando la pantalla.");

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}