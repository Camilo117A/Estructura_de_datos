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
        arbol.insertar(2450, "GrandMaster99", "Russia", 312);
        arbol.insertar(1950, "TacticoPro", "Colombia", 185);
        arbol.insertar(1720, "PeonValiente", "Mexico", 430);
        arbol.insertar(2100, "ElCapitan", "Argentina", 258);
        arbol.insertar(1580, "ReyDefensor", "Peru", 97);
        arbol.insertar(2310, "KnightRider", "USA", 201);
        arbol.insertar(1860, "BishopMaster", "Spain", 340);
        arbol.insertar(2050, "CastleKing", "France", 165);
        arbol.insertar(1400, "NoviceKnight", "Brazil", 45);
        arbol.insertar(2200, "QueenGambit", "Germany", 289);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("     TORNEO DE AJEDREZ - RANKING ELO    ");
        System.out.println("========================================");
        System.out.println("  1. Registrar jugador");
        System.out.println("  2. Listar todos los jugadores");
        System.out.println("  3. Jugadores clasificados por rango ELO");
        System.out.println("  4. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarJugador();
                break;
            case 2:
                listarTodos();
                break;
            case 3:
                clasificarPorRango();
                break;
            case 4:
                System.out.println("\nSistema cerrado.");
                break;
            default:
                System.out.println("\nOpcion no valida. Intente de nuevo.");
        }
    }

    private static void registrarJugador() {
        System.out.println("\n--- REGISTRO DE JUGADOR ---");
        System.out.print("ELO: ");
        int elo = leerEntero();
        scanner.nextLine();
        System.out.print("Nombre de usuario: ");
        String usuario = scanner.nextLine().trim();
        System.out.print("Pais: ");
        String pais = scanner.nextLine().trim();
        System.out.print("Partidas jugadas: ");
        int partidas = leerEntero();
        arbol.insertar(elo, usuario, pais, partidas);
        System.out.println("\nJugador registrado exitosamente.");
    }

    private static void listarTodos() {
        System.out.println("\n--- RANKING COMPLETO (menor a mayor ELO) ---");
        arbol.recorrerInOrden();
    }

    private static void clasificarPorRango() {
        System.out.println("\n--- CLASIFICACION POR RANGO ELO ---");
        System.out.print("ELO minimo: ");
        int eloMin = leerEntero();
        System.out.print("ELO maximo: ");
        int eloMax = leerEntero();
        System.out.printf("\nJugadores con ELO entre %d y %d:%n", eloMin, eloMax);
        arbol.listarEnRango(eloMin, eloMax);
    }

    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
