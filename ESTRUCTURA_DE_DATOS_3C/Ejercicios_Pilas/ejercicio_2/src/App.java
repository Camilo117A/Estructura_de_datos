import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaPiezas pila = new PilaPiezas();
        int opcion;

        do {
            System.out.println("\n===== CONTROL DE CALIDAD - LÍNEA DE ENSAMBLAJE =====");
            System.out.println("1. Agregar pieza");
            System.out.println("2. Retirar pieza del tope (pop)");
            System.out.println("3. Ver pieza en el tope (peek)");
            System.out.println("4. Limpiar hasta encontrar defecto");
            System.out.println("5. Mostrar pila completa");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la pieza: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de serie: ");
                    String serie = sc.nextLine();
                    System.out.print("¿Es defectuosa? (true/false): ");
                    boolean defectuosa = Boolean.parseBoolean(sc.nextLine().trim());
                    pila.push(new Pieza(nombre, serie, defectuosa));
                    System.out.println("Pieza agregada correctamente.");
                    break;

                case 2:
                    Pieza retirada = pila.pop();
                    if (retirada != null) {
                        System.out.println("Pieza retirada: " + retirada.nombrePieza + " [" + retirada.numeroSerie + "]");
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;

                case 3:
                    Pieza tope = pila.peek();
                    if (tope != null) {
                        System.out.println("Tope: " + tope.nombrePieza + " | Serie: " + tope.numeroSerie + " | Defectuosa: " + tope.esDefectuosa);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;

                case 4:
                    pila.limpiarHastaDefecto();
                    break;

                case 5:
                    pila.mostrarPila();
                    break;

                case 6:
                    System.out.println("Cerrando sistema de control de calidad.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}