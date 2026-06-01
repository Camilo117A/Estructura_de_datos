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
        arbol.insertar(1050, "Filtro de aceite", "Bosch", 12);
        arbol.insertar(502, "Bujia de encendido", "NGK", 45);
        arbol.insertar(1800, "Pastilla de freno delantera", "Ferodo", 8);
        arbol.insertar(230, "Correa de distribucion", "Gates", 5);
        arbol.insertar(750, "Amortiguador trasero", "Monroe", 3);
        arbol.insertar(1300, "Bomba de agua", "Dayco", 2);
        arbol.insertar(90, "Sensor de oxigeno", "Bosch", 7);
        arbol.insertar(2000, "Radiador completo", "Valeo", 1);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("    CONTROL DE INVENTARIO - REPUESTOS   ");
        System.out.println("========================================");
        System.out.println("  1. Registrar repuesto");
        System.out.println("  2. Listar inventario ordenado");
        System.out.println("  3. Backup en PreOrden");
        System.out.println("  4. Reporte de repuestos unicos");
        System.out.println("  5. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarRepuesto();
                break;
            case 2:
                listarInventario();
                break;
            case 3:
                generarBackup();
                break;
            case 4:
                arbol.reporteRepuestosUnicos();
                break;
            case 5:
                System.out.println("\nSistema cerrado.");
                break;
            default:
                System.out.println("\nOpcion no valida. Intente de nuevo.");
        }
    }

    private static void registrarRepuesto() {
        System.out.println("\n--- REGISTRO DE REPUESTO ---");
        System.out.print("Codigo de referencia: ");
        int codigo = leerEntero();
        scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine().trim();
        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();
        System.out.print("Stock inicial: ");
        int stock = leerEntero();
        arbol.insertar(codigo, descripcion, marca, stock);
        System.out.println("\nRepuesto registrado exitosamente.");
    }

    private static void listarInventario() {
        System.out.println("\n--- INVENTARIO ORDENADO POR CODIGO ---");
        arbol.recorrerInOrden();
    }

    private static void generarBackup() {
        System.out.println("\n--- BACKUP EN PREORDEN (para reconstruccion) ---");
        arbol.backupPreOrden();
    }

    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
