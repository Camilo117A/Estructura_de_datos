/* Algoritmos obligatorios: Selección vs Inserción

Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" 
en términos de operaciones para un caso específico.
Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS métodos 
al mismo conjunto de datos (puedes usar una copia del arreglo original).
Lógica de Conteo:
En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos 
hizo Inserción. El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado. */

import java.util.Scanner;

public class E5_Inspector_de_Eficiencia {

    static int contadorSwaps = 0;

    static int contadorMovimientos = 0;

    static int[] selectionSort(int[] arr) {
        int n = arr.length;
        contadorSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int temp = arr[i];
                arr[i] = arr[indiceMenor];
                arr[indiceMenor] = temp;
                contadorSwaps++; 
            }
        }

        return arr;
    }

    static int[] insertionSort(int[] arr) {
        int n = arr.length;
        contadorMovimientos = 0;

        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j]; 
                contadorMovimientos++; 
                j--;
            }

            arr[j + 1] = clave;
        }

        return arr;
    }

    static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL = 6;

        int[] original = new int[TOTAL];

        System.out.println("=== Inspector de Eficiencia: Selección vs Inserción ===");
        System.out.println("Ingresa " + TOTAL + " números enteros desordenados:");
        for (int i = 0; i < TOTAL; i++) {
            System.out.print("  Número " + (i + 1) + ": ");
            original[i] = scanner.nextInt();
        }

        System.out.print("\nArreglo original: ");
        imprimirArreglo(original);
        System.out.println();

        int[] copiaSeleccion = original.clone();
        int[] copiaInsercion = original.clone();

        System.out.println("\n--- Ejecutando Selection Sort ---");
        int[] resultadoSeleccion = selectionSort(copiaSeleccion);
        int swaps = contadorSwaps;
        System.out.print("Arreglo ordenado: ");
        imprimirArreglo(resultadoSeleccion);
        System.out.println();
        System.out.println("Swaps realizados: " + swaps);

        System.out.println("\n--- Ejecutando Insertion Sort ---");
        int[] resultadoInsercion = insertionSort(copiaInsercion);
        int movimientos = contadorMovimientos;
        System.out.print("Arreglo ordenado: ");
        imprimirArreglo(resultadoInsercion);
        System.out.println();
        System.out.println("Movimientos realizados: " + movimientos);

        System.out.println("\n=== RESUMEN DE EFICIENCIA ===");
        System.out.printf("  Selection Sort → %d swaps%n", swaps);
        System.out.printf("  Insertion Sort → %d movimientos%n", movimientos);

        System.out.println("\n Conclusión:");
        if (swaps < movimientos) {
            System.out.println("  Selection Sort fue más eficiente para estos datos.");
            System.out.println("  (Realizó menos operaciones de reubicación)");
        } else if (movimientos < swaps) {
            System.out.println("  Insertion Sort fue más eficiente para estos datos.");
            System.out.println("  (Realizó menos movimientos para ordenar)");
        } else {
            System.out.println("  Ambos algoritmos tuvieron la misma cantidad de operaciones.");
        }

        System.out.println("\n  Nota: Selection Sort siempre hace N-1 swaps como máximo.");
        System.out.println("  Insertion Sort puede ser 0 movimientos si ya está ordenado.");

        scanner.close();
    }
}
