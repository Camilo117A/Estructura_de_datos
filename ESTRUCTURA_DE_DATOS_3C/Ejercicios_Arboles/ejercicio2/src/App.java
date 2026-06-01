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
        } while (opcion != 4);
        scanner.close();
    }

    private static void cargarDatosDemostracion() {
        arbol.insertar(9780131103627L, "El Lenguaje de Programacion C", "Brian Kernighan", 1988);
        arbol.insertar(9780201633610L, "Design Patterns", "Gang of Four", 1994);
        arbol.insertar(9780596007126L, "Head First Design Patterns", "Eric Freeman", 2004);
        arbol.insertar(9780132350884L, "Clean Code", "Robert C. Martin", 2008);
        arbol.insertar(9780201485677L, "The Pragmatic Programmer", "Hunt y Thomas", 1999);
        arbol.insertar(9780743273565L, "El Gran Gatsby", "F. Scott Fitzgerald", 1925);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("    CATALOGO BIBLIOTECA UNIVERSITARIA   ");
        System.out.println("========================================");
        System.out.println("  1. Registrar nuevo libro");
        System.out.println("  2. Imprimir catalogo completo");
        System.out.println("  3. Verificar existencia de ISBN");
        System.out.println("  4. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarLibro();
                break;
            case 2:
                imprimirCatalogo();
                break;
            case 3:
                verificarISBN();
                break;
            case 4:
                System.out.println("\nSistema cerrado.");
                break;
            default:
                System.out.println("\nOpcion no valida. Intente de nuevo.");
        }
    }

    private static void registrarLibro() {
        System.out.println("\n--- REGISTRO DE NUEVO LIBRO ---");
        System.out.print("ISBN: ");
        long isbn = leerLong();
        if (arbol.existeISBN(isbn)) {
            System.out.println("\nEste ISBN ya se encuentra registrado en el catalogo.");
            return;
        }
        scanner.nextLine();
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        System.out.print("Anio de publicacion: ");
        int anio = leerEntero();
        arbol.insertar(isbn, titulo, autor, anio);
        System.out.println("\nLibro registrado exitosamente.");
    }

    private static void imprimirCatalogo() {
        System.out.println("\n--- CATALOGO ORDENADO POR ISBN ---");
        arbol.imprimirCatalogo();
    }

    private static void verificarISBN() {
        System.out.print("\nIngrese el ISBN a verificar: ");
        long isbn = leerLong();
        if (arbol.existeISBN(isbn)) {
            System.out.println("El ISBN " + isbn + " ya esta registrado en el catalogo.");
        } else {
            System.out.println("El ISBN " + isbn + " no existe en el catalogo. Puede registrarlo.");
        }
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
}
