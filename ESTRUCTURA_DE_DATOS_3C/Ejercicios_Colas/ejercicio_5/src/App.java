import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaPedidos cola = new ColaPedidos();
        int opcion;

        do {
            System.out.println("\n===== Fabrica de Pedidos =====");
            System.out.println("1. Registrar nuevo pedido");
            System.out.println("2. Procesar todos los pedidos");
            System.out.println("3. Ver cola de pedidos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Numero de pedido: ");
                String numero = sc.nextLine();
                System.out.print("Nombre del cliente: ");
                String cliente = sc.nextLine();
                System.out.print("Total a pagar: ");
                double total = sc.nextDouble();
                sc.nextLine();
                System.out.print("Esta cancelado? (s/n): ");
                String resp = sc.nextLine();
                boolean cancelado = resp.equalsIgnoreCase("s");
                cola.enqueue(new Pedido(numero, cliente, total, cancelado));
                System.out.println("Pedido registrado en el sistema.");

            } else if (opcion == 2) {
                cola.procesarPedidos();

            } else if (opcion == 3) {
                cola.mostrarCola();

            } else if (opcion != 0) {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        System.out.println("Sistema cerrado.");
        sc.close();
    }
}
