/* Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada. */

import java.util.Scanner;

public class E4_Control_de_Acceso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuántos códigos de socios desea ingresar: ");
        int n = sc.nextInt();

        int[] codigosSocios = new int[n];
        System.out.println("Ingrese los códigos de los socios de menor a mayor:");
        for (int i = 0; i < n; i++) {
            codigosSocios[i] = sc.nextInt();
        }

        System.out.print("Ingrese el código del socio que intenta acceder: ");
        int codigoIngresado = sc.nextInt();

        boolean accesoPermitido = busquedaBinaria(codigosSocios, codigoIngresado);

        if (accesoPermitido) {
            System.out.println("Acceso permitido, Bienvenido al gimnasio");
        } else {
            System.out.println("Acceso denegado, Código no encontrado.");
        }

        sc.close();
    }

    public static boolean busquedaBinaria(int[] arr, int target) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == target) {
                return true;
            } else if (arr[medio] < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return false;
    }
}
