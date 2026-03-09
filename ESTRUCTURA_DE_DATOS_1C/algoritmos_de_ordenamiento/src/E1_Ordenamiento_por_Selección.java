/* Ordenamiento por Selección (Selection Sort)
Descripción:

Implementa el algoritmo de selección que busca el valor mínimo en la lista desordenada y lo intercambia con el primer elemento no ordenado.
El ejercicio incluye un ejemplo con precios de productos en una tienda.
Reto Interactivo:

El programa solicita al usuario ingresar una cantidad de productos y sus valores correspondientes, para luego mostrarlos ordenados. */

public class E1_Ordenamiento_por_Selección {
    public static void main(String[] args) {
        int[] precios = {29, 10, 14, 37, 13};

        System.out.println("Precios antes de ordenar:");
        imprimirArreglo(precios);

        ordenamientoPorSeleccion(precios);

        System.out.println("\nPrecios después de ordenar:");
        imprimirArreglo(precios);
    }

    public static void ordenamientoPorSeleccion(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento no ordenado
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static void imprimirArreglo(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
