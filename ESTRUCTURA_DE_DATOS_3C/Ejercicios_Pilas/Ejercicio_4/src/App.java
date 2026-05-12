import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaMedicamentos pila = new PilaMedicamentos();
        int opcion;

        do {
            System.out.println("\n===== FARMACIA AUTOMATIZADA - DISPENSADOR LIFO =====");
            System.out.println("1. Cargar medicamento al dispensador");
            System.out.println("2. Retirar medicamento del tope (pop)");
            System.out.println("3. Ver medicamento en el tope (peek)");
            System.out.println("4. Validar y despachar medicamento");
            System.out.println("5. Mostrar dispensador completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del medicamento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de lote: ");
                    String lote = sc.nextLine();
                    System.out.print("Días para vencer: ");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    pila.push(new Medicamento(nombre, lote, dias));
                    System.out.println("Medicamento cargado en el dispensador.");
                    break;

                case 2:
                    Medicamento retirado = pila.pop();
                    if (retirado != null) {
                        System.out.println("Medicamento retirado: " + retirado.nombre + " | Lote: " + retirado.lote);
                    } else {
                        System.out.println("El dispensador está vacío.");
                    }
                    break;

                case 3:
                    Medicamento tope = pila.peek();
                    if (tope != null) {
                        System.out.println("Tope: " + tope.nombre + " | Lote: " + tope.lote + " | Días para vencer: " + tope.diasParaVencer);
                    } else {
                        System.out.println("El dispensador está vacío.");
                    }
                    break;

                case 4:
                    pila.validarDespacho();
                    break;

                case 5:
                    pila.mostrarPila();
                    break;

                case 6:
                    System.out.println("Cerrando sistema de dispensación.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
