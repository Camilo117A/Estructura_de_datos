public class inventario {
    //clase dispositivo con id (int), marca (string), y precio (double)
    public static class dispositivo {
        int id;
        String marca;
        double precio;

        public dispositivo(int id, String marca, double precio) {
            this.id = id;
            this.marca = marca;
            this.precio = precio;
        }
    }

    //pedir datos de 6 dispositivos y guardarlos en un arreglo
    public static void main(String[] args) {
        dispositivo[] dispositivos = new dispositivo[6];
        for (int i = 0; i < dispositivos.length; i++) {
            System.out.println("Dispositivo " + (i + 1) + ":");
            System.out.print("  ID: ");
            int id = new java.util.Scanner(System.in).nextInt();
            System.out.print("  Marca: ");
            String marca = new java.util.Scanner(System.in).nextLine();
            System.out.print("  Precio: ");
            double precio = new java.util.Scanner(System.in).nextDouble();
            dispositivos[i] = new dispositivo(id, marca, precio);
        }

        //pide al usuario si quiere ordenar por id, buscar por id, o mostrar el dispositivo mas costoso
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Ordenar por ID");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Mostrar dispositivo más costoso");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    ordenarPorID(dispositivos);
                    System.out.println("Dispositivos ordenados por ID:");
                    for (dispositivo d : dispositivos) {
                        System.out.printf("ID: %d | Marca: %s | Precio: $%.2f%n", d.id, d.marca, d.precio);
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el ID a buscar: ");
                    int idBuscado = new java.util.Scanner(System.in).nextInt();
                    busquedaBinaria(dispositivos, idBuscado);
                    break;
                case 3:
                    dispositivoMasCostoso(dispositivos);
                    break;
                case 4:
                    opcion = 4;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    //crea shell sort para ordenar por id (menor a mayor)
    public static void ordenarPorID(dispositivo[] dispositivos) {
        int n = dispositivos.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                dispositivo temp = dispositivos[i];
                int j;
                for (j = i; j >= gap && dispositivos[j - gap].id > temp.id; j -= gap) {
                    dispositivos[j] = dispositivos[j - gap];
                }
                dispositivos[j] = temp;
            }
        }
    }

    //crea busqueda binaria para buscar por id y muestra toda su informacion
    public static void busquedaBinaria(dispositivo[] dispositivos, int idBuscado) {
        int inicio = 0;
        int fin = dispositivos.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (dispositivos[medio].id == idBuscado) {
                System.out.printf("Dispositivo encontrado: ID: %d | Marca: %s | Precio: $%.2f%n", dispositivos[medio].id, dispositivos[medio].marca, dispositivos[medio].precio);
                return;
            } else if (dispositivos[medio].id < idBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        System.out.println("Dispositivo no encontrado.");
    }

    //indica la marca y precio del dispositivo mas costoso
    public static void dispositivoMasCostoso(dispositivo[] dispositivos) {
        double maxPrecio = Double.MIN_VALUE;
        String marcaMax = "";
        for (dispositivo d : dispositivos) {
            if (d.precio > maxPrecio) {
                maxPrecio = d.precio;
                marcaMax = d.marca;
            }
        }
        System.out.println("El dispositivo más costoso es de la marca (" + marcaMax + ") con un precio de $(" + maxPrecio + ")");
    }
}
