public class App {

    public static void main(String[] args) {

        Reproductor reproductor = new Reproductor();

        reproductor.agregar_cancion("Blinding Lights", "The Weeknd", 200);
        reproductor.agregar_cancion("Shape of You",    "Ed Sheeran", 234);
        reproductor.agregar_cancion("Levitating",      "Dua Lipa",   203);
        reproductor.agregar_cancion("Stay",            "Kid Laroi",  141);

        System.out.println();
        reproductor.mostrar_playlist();

        System.out.println("\n-- Avanzando canciones --");
        reproductor.saltar_adelante();
        reproductor.saltar_adelante();

        System.out.println();
        reproductor.mostrar_playlist();

        System.out.println("\n-- Retrocediendo una cancion --");
        reproductor.saltar_atras();

        System.out.println();
        reproductor.mostrar_playlist();

        System.out.println("\n-- Intentando retroceder desde la primera cancion --");
        reproductor.saltar_atras();
        reproductor.saltar_atras();

        System.out.println("\n-- Intentando avanzar desde la ultima cancion --");
        reproductor.saltar_adelante();
        reproductor.saltar_adelante();
        reproductor.saltar_adelante();
        reproductor.saltar_adelante();
    }
}