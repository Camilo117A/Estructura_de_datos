import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaEstaciones pila = new PilaEstaciones();
        int opcion;

        do {
            System.out.println("\n===== RUTA DE RESCATE - ESPELEOLOGÍA GEOLÓGICA =====");
            System.out.println("1. Registrar estación de seguridad");
            System.out.println("2. Eliminar última estación registrada (pop)");
            System.out.println("3. Ver estación en el tope (peek)");
            System.out.println("4. Retroceder a la superficie");
            System.out.println("5. Mostrar todas las estaciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del punto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Profundidad (metros): ");
                    int profundidad = sc.nextInt();
                    System.out.print("Nivel de oxígeno (%): ");
                    double oxigeno = sc.nextDouble();
                    sc.nextLine();
                    pila.push(new Estacion(nombre, profundidad, oxigeno));
                    System.out.println("Estación registrada correctamente.");
                    break;

                case 2:
                    Estacion retirada = pila.pop();
                    if (retirada != null) {
                        System.out.println("Estación eliminada: " + retirada.nombrePunto);
                    } else {
                        System.out.println("No hay estaciones registradas.");
                    }
                    break;

                case 3:
                    Estacion tope = pila.peek();
                    if (tope != null) {
                        System.out.println("Tope: " + tope.nombrePunto + " | Profundidad: " + tope.profundidad + "m | Oxígeno: " + tope.nivelOxigeno + "%");
                    } else {
                        System.out.println("No hay estaciones registradas.");
                    }
                    break;

                case 4:
                    pila.retrocederASuperficie();
                    break;

                case 5:
                    pila.mostrarPila();
                    break;

                case 6:
                    System.out.println("Cerrando sistema de ruta de rescate.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
