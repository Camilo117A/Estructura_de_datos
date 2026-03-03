import java.util.Scanner;

public class reto_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cuentasVIP = {10, 25, 40, 80, 150};

        int[] cuentas = new int[5];
        double[] montos = new double[5];

        for (int i = 0; i < cuentasVIP.length; i++) {
            System.out.println("Cuenta VIP " + (i + 1) + ": " + cuentasVIP[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print("Transacción " + (i + 1) + " Número de cuenta: ");
            cuentas[i] = sc.nextInt();
            System.out.print("Transacción " + (i + 1) + " Monto: ");
            montos[i] = sc.nextDouble();
            System.out.println();
        }


        for (int i = 0; i < 5; i++) {
            if (montos[i] > 5000) {
                System.out.println("\nTransacción " + (i + 1) + " supera $5,000");
                System.out.printf("   Cuenta: %d  |  Monto: $%.2f%n", cuentas[i], montos[i]);

                boolean esVIP = busquedaBinaria(cuentasVIP, cuentas[i]);

                if (esVIP) {
                    System.out.println(" Cuenta VIP verificada. Transacción autorizada.");
                }
            }
            else {
                System.out.println("\nTransacción " + (i + 1) + " no supera $5,000");
                System.out.printf("   Cuenta: %d  |  Monto: $%.2f%n", cuentas[i], montos[i]);
                System.out.println("Alerta de fraude: Cuenta no autorizada para montos altos.");
            }
        }

        sc.close();
    }

    static boolean busquedaBinaria(int[] arreglo, int valorBuscado) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == valorBuscado) {
                return true;
            } else if (arreglo[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return false;
    }
}
