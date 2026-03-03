/* Buscador de Cédulas (Base de Datos Bancaria)
Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente por su número de cédula o ID.

El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos de la manera más rápida posible (en pocos pasos).
Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá encontrar al cliente dividiendo la lista a la mitad en cada paso. */

public class E2_Buscador_de_Cédulas {
    public static void main(String[] args) {
        int[] cedulas = {100001, 100002, 100003, 100004, 100005, 100006, 100007, 100008, 100009, 100010};
        int cedulaBuscada = 100007;

        int resultado = busquedaBinaria(cedulas, cedulaBuscada);

        if (resultado != -1) {
            System.out.println("Cliente encontrado en la posición: " + resultado);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static int busquedaBinaria(int[] arr, int target) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] == target) {
                return medio;
            } else if (arr[medio] < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }
}
