/* Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada. */

public class E4_Control_de_Acceso {
    public static void main(String[] args) {
        int[] codigosSocios = {1001, 1023, 1050, 1100, 1150, 1200, 1250};
        int codigoIngresado = 1100;

        boolean accesoPermitido = busquedaBinaria(codigosSocios, codigoIngresado);

        if (accesoPermitido) {
            System.out.println("Acceso permitido, Bienvenido al gimnasio");
        } else {
            System.out.println("Acceso denegado, Código no encontrado.");
        }
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
