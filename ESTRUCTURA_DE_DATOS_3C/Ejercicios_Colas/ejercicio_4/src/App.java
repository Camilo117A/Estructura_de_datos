import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaPeaje cola = new ColaPeaje();
        int opcion;

        do {
            System.out.println("\n===== Peaje Inteligente =====");
            System.out.println("1. Registrar vehiculo en carril");
            System.out.println("2. Cobrar siguiente vehiculo");
            System.out.println("3. Cerrar turno (procesar todos)");
            System.out.println("4. Ver carril actual");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Placa: ");
                String placa = sc.nextLine();
                System.out.print("Tipo de vehiculo: ");
                String tipo = sc.nextLine();
                System.out.print("Tarifa: ");
                double tarifa = sc.nextDouble();
                sc.nextLine();
                System.out.print("Es exento? (s/n): ");
                String resp = sc.nextLine();
                boolean exento = resp.equalsIgnoreCase("s");
                cola.enqueue(new Vehiculo(placa, tipo, tarifa, exento));
                System.out.println("Vehiculo registrado en el carril.");

            } else if (opcion == 2) {
                Vehiculo v = cola.dequeue();
                if (v == null) {
                    System.out.println("No hay vehiculos en el carril.");
                } else {
                    System.out.println("\nProcesando vehiculo:");
                    System.out.println("  Placa  : " + v.placa);
                    System.out.println("  Tipo   : " + v.tipoVehiculo);
                    if (v.esExento) {
                        System.out.println("  Estado : Exento de pago");
                    } else {
                        System.out.println("  Tarifa : $" + String.format("%.2f", v.tarifa));
                    }
                }

            } else if (opcion == 3) {
                cola.cerrarTurno();

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
