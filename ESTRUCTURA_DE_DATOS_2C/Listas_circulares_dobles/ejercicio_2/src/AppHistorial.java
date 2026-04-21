
import java.util.Scanner;

public class AppHistorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HistorialTerminal historial = new HistorialTerminal();
        int opcion;
        do {
            System.out.println("\n==============================================");
            System.out.println("        Historial de Terminal");
            System.out.println("==============================================");
            System.out.println("1. Agregar comando");
            System.out.println("2. Flecha arriba (comando anterior)");
            System.out.println("3. Flecha abajo  (comando siguiente)");
            System.out.println("4. Ver comando actual (cursor)");
            System.out.println("5. Eliminar comando actual");
            System.out.println("6. Mostrar historial completo");
            System.out.println("7. Cargar ejemplo (5 comandos simulados)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Texto del comando: ");
                    String texto = sc.nextLine();
                    System.out.print("¿Ejecutó sin errores? (true/false): ");
                    boolean exitoso = Boolean.parseBoolean(sc.nextLine().trim());
                    System.out.print("Directorio (ej: /home/user): ");
                    String dir = sc.nextLine();
                    historial.agregar(texto, exitoso, dir);
                    System.out.println("Comando agregado.");
                    break;

                case 2:
                    historial.arriba();
                    break;

                case 3:
                    historial.abajo();
                    break;

                case 4:
                    historial.mostrarCursor();
                    break;

                case 5:
                    historial.eliminarActual();
                    break;

                case 6:
                    historial.mostrarHistorial();
                    break;

                case 7:
                    historial = new HistorialTerminal();
                    historial.agregar("ls -la",         true,  "/home/user");
                    historial.agregar("cd proyectos",   true,  "/home/user");
                    historial.agregar("git status",     true,  "/home/user/proyectos");
                    historial.agregar("sudo",  false, "/home/user");
                    historial.agregar("App.java", true,  "/home/user/proyectos");

                    System.out.println("5 comandos cargados. Cursor en el más reciente.");
                    historial.mostrarHistorial();

                    System.out.println("\n--- Navegando 3 veces hacia arriba ---");
                    historial.arriba();
                    historial.arriba();
                    historial.arriba();

                    System.out.println("\n--- Eliminando el comando actual ---");
                    historial.eliminarActual();

                    System.out.println("\n--- Navegando 1 vez hacia abajo ---");
                    historial.abajo();

                    System.out.println("\n--- Estado final del historial ---");
                    historial.mostrarHistorial();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
