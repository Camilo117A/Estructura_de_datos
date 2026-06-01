import java.util.Scanner;

public class App {
    private static ArbolBST arbol = new ArbolBST();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosDemostracion();
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero();
            procesarOpcion(opcion);
        } while (opcion != 5);
        scanner.close();
    }

    private static void cargarDatosDemostracion() {
        arbol.insertar(10234567L, "Carlos Herrera Rios", "Conductor", 2800000);
        arbol.insertar(52341890L, "Maria Lopez Vega", "Supervisora", 4500000);
        arbol.insertar(31987654L, "Andres Mora Suarez", "Almacenista", 2200000);
        arbol.insertar(71234509L, "Luisa Fernanda Pena", "Gerente", 8000000);
        arbol.insertar(19876543L, "Jorge Castillo Alba", "Auxiliar", 1900000);
        arbol.insertar(40123456L, "Patricia Ruiz Leon", "Contadora", 5500000);
        arbol.insertar(63045678L, "Santiago Gomez Cruz", "Tecnico", 3100000);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("       SISTEMA DE NOMINA - BST          ");
        System.out.println("========================================");
        System.out.println("  1. Registrar empleado");
        System.out.println("  2. Listar nomina completa");
        System.out.println("  3. Empleado con cedula minima");
        System.out.println("  4. Empleado con cedula maxima");
        System.out.println("  5. Reporte de eficiencia del arbol");
        System.out.println("  6. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarEmpleado();
                break;
            case 2:
                listarNomina();
                break;
            case 3:
                arbol.buscarMinimo();
                break;
            case 4:
                arbol.buscarMaximo();
                break;
            case 5:
                arbol.reporteEficiencia();
                break;
            case 6:
                System.out.println("\nSistema cerrado.");
                opcion = 5;
                return;
            default:
                System.out.println("\nOpcion no valida. Intente de nuevo.");
        }
    }

    private static void registrarEmpleado() {
        System.out.println("\n--- REGISTRO DE EMPLEADO ---");
        System.out.print("Cedula: ");
        long cedula = leerLong();
        scanner.nextLine();
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine().trim();
        System.out.print("Salario: ");
        double salario = leerDouble();
        arbol.insertar(cedula, nombre, cargo, salario);
        System.out.println("\nEmpleado registrado exitosamente.");
    }

    private static void listarNomina() {
        System.out.println("\n--- NOMINA ORDENADA POR CEDULA ---");
        arbol.recorrerInOrden();
    }

    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static long leerLong() {
        while (!scanner.hasNextLong()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextLong();
    }

    private static double leerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
