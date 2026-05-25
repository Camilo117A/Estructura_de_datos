import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaUrgencias cola = new ColaUrgencias();
        int opcion;

        do {
            System.out.println("\n===== Urgencias Hospitalarias =====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Llamar siguiente paciente");
            System.out.println("3. Atender todos los pacientes del turno");
            System.out.println("4. Ver sala de espera");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Cedula: ");
                String cedula = sc.nextLine();
                System.out.print("Nombre completo: ");
                String nombre = sc.nextLine();
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();
                System.out.print("Sintoma principal: ");
                String sintoma = sc.nextLine();
                cola.enqueue(new Paciente(cedula, nombre, edad, sintoma));
                System.out.println("Paciente registrado en sala de espera.");

            } else if (opcion == 2) {
                Paciente p = cola.dequeue();
                if (p == null) {
                    System.out.println("No hay pacientes en espera.");
                } else {
                    System.out.println("\nLlamando a paciente:");
                    System.out.println("  Cedula  : " + p.cedula);
                    System.out.println("  Nombre  : " + p.nombreCompleto);
                    System.out.println("  Edad    : " + p.edad + " anios");
                    System.out.println("  Sintoma : " + p.sintomaPrincipal);
                }

            } else if (opcion == 3) {
                cola.atenderTodos();

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
