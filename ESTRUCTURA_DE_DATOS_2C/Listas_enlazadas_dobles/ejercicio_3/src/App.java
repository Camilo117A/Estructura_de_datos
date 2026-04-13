import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Navegador navegador = new Navegador();
        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\n====== Navegador de Pestanas ======");
            System.out.println("1. Abrir nueva pestana");
            System.out.println("2. Cerrar pestana por URL");
            System.out.println("3. Salir");
            System.out.println("4. Ver pestanas abiertas");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Titulo de la pagina: ");
                String titulo_pagina = scanner.nextLine();
                System.out.print("URL: ");
                String url = scanner.nextLine();
                System.out.print("Hora de apertura (ej: 08:30): ");
                String hora_apertura = scanner.nextLine();
                navegador.abrir_pestana(titulo_pagina, url, hora_apertura);

            } else if (opcion == 2) {
                System.out.print("Ingresa la URL de la pestana a cerrar: ");
                String url = scanner.nextLine();
                navegador.cerrar_pestana_actual(url);

            } else if (opcion == 3) {
                System.out.println("Cerrando el navegador.");

            } else if (opcion == 4) {
                navegador.mostrar_pestanas();

            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}