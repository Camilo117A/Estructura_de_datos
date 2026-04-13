import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion = 0;

        while (opcion != 6) {

            System.out.println("\n====== Galeria de Fotos ======");
            System.out.println("1. Agregar foto");
            System.out.println("2. Foto siguiente");
            System.out.println("3. Foto anterior");
            System.out.println("4. Ver foto actual");
            System.out.println("5. Reproducir galeria completa");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del archivo (ej: foto.jpg): ");
                String nombre_archivo = scanner.nextLine();
                System.out.print("Tamano en MB: ");
                double tamano_mb = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Resolucion (ej: 1920x1080): ");
                String resolucion = scanner.nextLine();
                galeria.agregar_foto(nombre_archivo, tamano_mb, resolucion);

            } else if (opcion == 2) {
                galeria.siguiente_foto();

            } else if (opcion == 3) {
                galeria.foto_anterior();

            } else if (opcion == 4) {
                galeria.mostrar_foto_actual();

            } else if (opcion == 5) {
                galeria.reproducir_galeria();

            } else if (opcion == 6) {
                System.out.println("Cerrando galeria.");

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}