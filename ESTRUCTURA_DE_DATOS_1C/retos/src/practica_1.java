import java.util.Scanner;

public class practica_1 {

    Scanner scanner = new Scanner(System.in);

    static productos[] productos = new productos[5];

    public static class productos {
        String id;
        String nombre;
        double precio;
        int cantidad;

        public productos(String id, String nombre, double precio, int cantidad) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Cuántos productos deseas ingresar: ");
            int n = scanner.nextInt();


    for (int i = 0; i < n; i++) {
            System.out.println("--- REGISTRO DE PRODUCTOS ---");

            System.out.println("\nProducto " + (i + 1) + ":");

            System.out.print("  ingresar ID: ");
            String id = scanner.next();

            System.out.print("  Nombre: ");
            String nombre = scanner.next();

            System.out.print("  Precio: ");
            double precio = scanner.nextDouble();

            System.out.print("  Cantidad: ");
            int cantidad = scanner.nextInt();

            //agregar producto al arreglo
            if (i < productos.length) {
                productos[i] = new productos(id, nombre, precio, cantidad);
            } else {
                System.out.println("No se pueden ingresar más productos. El límite es de " + productos.length + ".");
                break;
            }
        }
    }
        ordenarProductosPorID(productos);
        int m = 0;
        while (m > 1) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Mostrar todos los productos");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            try (Scanner scanner = new Scanner(System.in)) {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        ordenarProductosPorID(productos);
                        mostrarProductos(productos);
                        break;
                    case 2:
                        System.out.print("Ingresa el ID del producto a buscar: ");
                        String id = scanner.next();
                        ordenarProductosPorID(productos);
                        buscarProductoPorID(productos, id);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        m = 2;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor selecciona una opción del menú.");
                }
            }
        }
    }

    public static void mostrarProductos(productos[] productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i + 1) + ":");
            System.out.println("  ID: " + productos[i].id);
            System.out.println("  Nombre: " + productos[i].nombre);
            System.out.println("  Precio: " + productos[i].precio);
            System.out.println("  Cantidad: " + productos[i].cantidad);
        }
    }

    //buscar producto por ID
    public static void buscarProductoPorID(productos[] productos, String id) {
        System.out.println("\n--- BUSCAR PRODUCTO POR ID ---");
        boolean encontrado = false;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].id.equals(id)) {
                System.out.println("Producto encontrado:");
                System.out.println("  ID: " + productos[i].id);
                System.out.println("  Nombre: " + productos[i].nombre);
                System.out.println("  Precio: " + productos[i].precio);
                System.out.println("  Cantidad: " + productos[i].cantidad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    }

    //ordenar productos por ID de shell sort
    public static void ordenarProductosPorID(productos[] productos) {
        int n = productos.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                productos temp = productos[i];
                int j;
                for (j = i; j >= gap && productos[j - gap].id.compareTo(temp.id) > 0; j -= gap) {
                    productos[j] = productos[j - gap];
                }
                productos[j] = temp;
            }
        }
    }
}
