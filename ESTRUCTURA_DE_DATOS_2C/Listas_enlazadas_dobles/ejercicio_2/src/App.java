public class App {

    public static void main(String[] args) {

        Galeria galeria = new Galeria();

        galeria.agregar_foto("vacaciones1.jpg", 3.5, "1920x1080");
        galeria.agregar_foto("cumpleanos.png", 5.2, "4K");
        galeria.agregar_foto("paisaje.jpg", 2.8, "1280x720");
        galeria.agregar_foto("retrato.png", 4.1, "3840x2160");

        System.out.println();
        System.out.println("-- Foto actual al inicio --");
        galeria.mostrar_foto_actual();

        System.out.println("\n-- Avanzando fotos --");
        galeria.siguiente_foto();
        galeria.siguiente_foto();

        System.out.println("\n-- Retrocediendo una foto --");
        galeria.foto_anterior();

        System.out.println("\n-- Intentando retroceder desde la primera --");
        galeria.foto_anterior();
        galeria.foto_anterior();

        System.out.println("\n-- Reproduccion completa de la galeria --");
        galeria.reproducir_galeria();
    }
}