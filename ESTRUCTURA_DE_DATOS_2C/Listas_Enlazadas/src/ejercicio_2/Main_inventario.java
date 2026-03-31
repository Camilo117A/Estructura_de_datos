import java.util.Scanner;

public class Main_inventario {
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        inventario Estante = new inventario();
        int Opcion = 0;

        while (Opcion != 4) {
            System.out.println("\n--- MENU INVENTARIO LACTEOS ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar estante completo");
            System.out.println("3. Mostrar proximos a vencer");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            Opcion = Lector.nextInt();
            Lector.nextLine();

            if (Opcion == 1) {
                System.out.print("Nombre del producto: ");
                String Nombre = Lector.nextLine();
                System.out.print("Cantidad: ");
                int Cantidad = Lector.nextInt();
                System.out.print("Dias para vencer: ");
                int Dias_para_vencer = Lector.nextInt();
                Lector.nextLine();
                Estante.agregarProducto(new producto(Nombre, Cantidad, Dias_para_vencer));
                System.out.println("Producto agregado.");

            } else if (Opcion == 2) {
                Estante.mostrarEstante();

            } else if (Opcion == 3) {
                Estante.mostrarProximos_a_vencer();

            } else if (Opcion != 4) {
                System.out.println("Opcion no valida.");
            }
        }
        System.out.println("Hasta luego.");
        Lector.close();
    }
}
