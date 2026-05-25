import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaImpresora cola = new ColaImpresora();
        int opcion;

        do {
            System.out.println("\n===== Impresora Compartida =====");
            System.out.println("1. Enviar documento a imprimir");
            System.out.println("2. Imprimir siguiente documento");
            System.out.println("3. Ver total de paginas en espera");
            System.out.println("4. Ver cola de impresion");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del archivo: ");
                String nombre = sc.nextLine();
                System.out.print("Usuario: ");
                String usuario = sc.nextLine();
                System.out.print("Numero de paginas: ");
                int paginas = sc.nextInt();
                sc.nextLine();
                System.out.print("Es a color? (s/n): ");
                String resp = sc.nextLine();
                boolean esColor = resp.equalsIgnoreCase("s");
                cola.enqueue(new Documento(nombre, usuario, paginas, esColor));
                System.out.println("Documento agregado a la cola.");

            } else if (opcion == 2) {
                Documento d = cola.dequeue();
                if (d == null) {
                    System.out.println("No hay documentos en la cola.");
                } else {
                    System.out.println("\nImprimiendo:");
                    System.out.println("  Archivo  : " + d.nombreArchivo);
                    System.out.println("  Usuario  : " + d.usuario);
                    System.out.println("  Paginas  : " + d.numeroPaginas);
                    System.out.println("  Color    : " + (d.esColor ? "Si" : "No"));
                }

            } else if (opcion == 3) {
                int total = cola.calcularPaginasTotales();
                System.out.println("Total de paginas pendientes de imprimir: " + total);

            } else if (opcion == 4) {
                cola.mostrarCola();

            } else if (opcion != 0) {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        System.out.println("Sistema cerrado.");
        sc.close();
    }
}
