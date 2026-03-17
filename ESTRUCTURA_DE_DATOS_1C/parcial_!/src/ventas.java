public class ventas {
    //pide 5 montos (double) y guardalos en un arreglo
    public static void main(String[] args) {
        double[] montos = new double[5];
        for (int i = 0; i < montos.length; i++) {
            System.out.print("Ingresa el monto " + (i + 1) + ": ");
            montos[i] = new java.util.Scanner(System.in).nextDouble();
        }

        int opcion = 0;
            while (opcion != 3) {
                System.out.println("\n--- MENÚ DE OPCIONES ---");
                System.out.println("1. Mostrar montos ordenados");
                System.out.println("2. Buscar un monto");
                System.out.println("3. Mostrar suma total");
                System.out.println("4. salir");
                System.out.print("Selecciona una opción: ");
                opcion = new java.util.Scanner(System.in).nextInt();
                switch (opcion) {
                    case 1:
                        ordenarMontos(montos);
                        System.out.println("Montos ordenados:");
                        for (double monto : montos) {
                            System.out.println(monto);
                        }
                        break;
                    case 2:
                        System.out.print("Ingresa el monto a buscar: ");
                        double montoBuscado = new java.util.Scanner(System.in).nextDouble();
                        if (buscarMonto(montos, montoBuscado)) {
                            System.out.println("Monto encontrado.");
                            System.out.println(montoBuscado);
                        } else {
                            System.out.println("Monto no encontrado.");
                        }
                        break;
                    case 3:
                        System.out.println("Suma total de los montos: " + sumaTotal(montos));
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            }
    }

    public static void ordenarMontos(double[] montos) {
        int n = montos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (montos[j] > montos[j + 1]) {
                    double temp = montos[j];
                    montos[j] = montos[j + 1];
                    montos[j + 1] = temp;
                }
            }
        }
    }

    public static boolean buscarMonto(double[] montos, double montoBuscado) {
        for (double monto : montos) {
            if (monto == montoBuscado) {
                return true;
            }
        }
        return false;
    }

    public static double sumaTotal(double[] montos) {
        double suma = 0;
        for (double monto : montos) {
            suma += monto;
        }
        return suma;
    }
}
