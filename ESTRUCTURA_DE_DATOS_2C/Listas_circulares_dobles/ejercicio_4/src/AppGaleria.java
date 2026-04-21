
import java.util.Scanner;

public class AppGaleria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion;
        do {
            System.out.println("\n==============================================");
            System.out.println("        Galería de Fotos");
            System.out.println("==============================================");
            System.out.println("1. Agregar foto");
            System.out.println("2. Foto siguiente →");
            System.out.println("3. Foto anterior  ←");
            System.out.println("4. Marcar / desmarcar favorita");
            System.out.println("5. Eliminar foto actual");
            System.out.println("6. Mostrar galería completa");
            System.out.println("7. Cargar ejemplo (5 fotos simuladas)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Título de la foto: ");
                    String titulo = sc.nextLine();
                    System.out.print("Fecha (ej: 2024-12-01): ");
                    String fecha = sc.nextLine();
                    System.out.print("¿Es favorita? (true/false): ");
                    boolean fav = Boolean.parseBoolean(sc.nextLine().trim());
                    galeria.agregarFoto(titulo, fecha, fav);
                    System.out.println("Foto '" + titulo + "' agregada.");
                    break;

                case 2:
                    galeria.siguiente();
                    break;

                case 3:
                    galeria.anterior();
                    break;

                case 4:
                    galeria.toggleFavorita();
                    break;

                case 5:
                    galeria.eliminarActual();
                    break;

                case 6:
                    galeria.mostrarGaleria();
                    break;

                case 7:
                    galeria = new Galeria();
                    galeria.agregarFoto("Atardecer en el mar",  "2024-01-15", false);
                    galeria.agregarFoto("Cumpleaños de Ana",    "2024-03-22", false);
                    galeria.agregarFoto("Viaje a Cartagena",    "2024-06-10", false);
                    galeria.agregarFoto("Graduación",           "2024-11-05", false);
                    galeria.agregarFoto("Navidad en familia",   "2024-12-25", false);

                    System.out.println("5 fotos cargadas. Viendo la primera.");
                    galeria.mostrarGaleria();

                    System.out.println("\n--- Avanzando 2 fotos ---");
                    galeria.siguiente();
                    galeria.siguiente();

                    System.out.println("\n--- Marcando la foto actual como favorita ---");
                    galeria.toggleFavorita();

                    System.out.println("\n--- Retrocediendo 1 foto ---");
                    galeria.anterior();

                    System.out.println("\n--- Eliminando la foto actual ---");
                    galeria.eliminarActual();

                    System.out.println("\n--- Estado final de la galería ---");
                    galeria.mostrarGaleria();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
