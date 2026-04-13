public class App {

    public static void main(String[] args) {

        Navegador navegador = new Navegador();

        navegador.abrir_pestana("Google",    "https://www.google.com",    "08:00");
        navegador.abrir_pestana("YouTube",   "https://www.youtube.com",   "08:05");
        navegador.abrir_pestana("Wikipedia", "https://www.wikipedia.org", "08:10");
        navegador.abrir_pestana("GitHub",    "https://www.github.com",    "08:15");

        System.out.println();
        navegador.mostrar_pestanas();

        System.out.println("\n-- Cerrando pestana de Wikipedia (intermedia) --");
        navegador.cerrar_pestana_actual("https://www.wikipedia.org");
        navegador.mostrar_pestanas();

        System.out.println("\n-- Cerrando la primera pestana (cabeza) --");
        navegador.cerrar_pestana_actual("https://www.google.com");
        navegador.mostrar_pestanas();

        System.out.println("\n-- Cerrando la ultima pestana (cola) --");
        navegador.cerrar_pestana_actual("https://www.github.com");
        navegador.mostrar_pestanas();

        System.out.println("\n-- Intentando cerrar una URL que no existe --");
        navegador.cerrar_pestana_actual("https://www.inventada.com");
    }
}