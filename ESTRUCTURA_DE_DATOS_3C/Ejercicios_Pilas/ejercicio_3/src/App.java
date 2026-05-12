import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaCamiones pila = new PilaCamiones();
        int opcion;

        do {
            System.out.println("\n===== LOGÍSTICA DE DISTRIBUCIÓN - CALLEJÓN SIN SALIDA =====");
            System.out.println("1. Ingresar camión al callejón");
            System.out.println("2. Retirar camión del callejón (pop)");
            System.out.println("3. Ver camión en el tope (peek)");
            System.out.println("4. Calcular carga total en el callejón");
            System.out.println("5. Mostrar todos los camiones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Placa del camión: ");
                    String placa = sc.nextLine();
                    System.out.print("Nombre del conductor: ");
                    String conductor = sc.nextLine();
                    System.out.print("Carga en toneladas: ");
                    double carga = sc.nextDouble();
                    sc.nextLine();
                    pila.push(new Camion(placa, conductor, carga));
                    System.out.println("Camión ingresado al callejón.");
                    break;

                case 2:
                    Camion retirado = pila.pop();
                    if (retirado != null) {
                        System.out.println("Camión retirado: " + retirado.placa + " | Conductor: " + retirado.conductor);
                    } else {
                        System.out.println("El callejón está vacío.");
                    }
                    break;

                case 3:
                    Camion tope = pila.peek();
                    if (tope != null) {
                        System.out.println("Tope: " + tope.placa + " | Conductor: " + tope.conductor + " | Carga: " + tope.cargaToneladas + "t");
                    } else {
                        System.out.println("El callejón está vacío.");
                    }
                    break;

                case 4:
                    double total = pila.calcularCargaTotal();
                    System.out.println("Carga total en el callejón: " + total + " toneladas");
                    break;

                case 5:
                    pila.mostrarPila();
                    break;

                case 6:
                    System.out.println("Cerrando sistema de logística.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
