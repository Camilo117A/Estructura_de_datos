import java.util.Scanner;

public class Main_playlist {
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        Lista_reproduccion Playlist = new Lista_reproduccion();
        int Opcion = 0;

        while (Opcion != 5) {
            System.out.println("\n--- MENÚ SPOTIFY LITE ---");
            System.out.println("1. Agregar canción al final");
            System.out.println("2. Agregar canción a continuación");
            System.out.println("3. Mostrar lista de reproducción");
            System.out.println("4. Mostrar tiempo total");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            Opcion = Lector.nextInt();
            Lector.nextLine();

            if (Opcion == 1 || Opcion == 2) {
                System.out.print("Título de la canción: ");
                String Titulo = Lector.nextLine();
                System.out.print("Artista: ");
                String Artista = Lector.nextLine();
                System.out.print("Duración en segundos: ");
                int Duracion_segundos = Lector.nextInt();
                Lector.nextLine();
                System.out.print("Género: ");
                String Genero = Lector.nextLine();

                if (Opcion == 1) {
                    Playlist.agregarAlFinal(new Cancion(Titulo, Artista, Duracion_segundos, Genero));
                } else {
                    Playlist.agregarAContinuacion(new Cancion(Titulo, Artista, Duracion_segundos, Genero));
                }

            } else if (Opcion == 3) {
                Playlist.mostrarLista();

            } else if (Opcion == 4) {
                Playlist.mostrarTiempo_total();

            } else if (Opcion != 5) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Hasta luego!");
        Lector.close();
    }
}
