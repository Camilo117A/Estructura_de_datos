import java.util.Scanner;

public class menu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        alamacen Almacen = new alamacen();
        do {
            System.out.println("\n==============================================");
            System.out.println("   Almacen — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. agregarProducto");
            System.out.println("2. mostrarInventario");
            System.out.println("3. eliminarProducto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                        System.out.print("Ingrese el código del producto: ");
                        String codigo = sc.next();
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.next();
                        System.out.print("Ingrese la cantidad del producto: ");
                        int cantidad = sc.nextInt();
                        System.out.print("Ingrese el precio del producto: ");
                        float precio = sc.nextFloat();
                        Almacen.agregarProducto(codigo, nombre, cantidad, precio);                    
                    break;

                case 2:
                    System.out.println("Inventario de Productos:");
                    Almacen.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = sc.next();
                    Almacen.eliminarProducto(codigoEliminar);
                    break;
                
                case 0:
                    System.out.println("¡Saliendo del almacen!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0); 
    }
}
