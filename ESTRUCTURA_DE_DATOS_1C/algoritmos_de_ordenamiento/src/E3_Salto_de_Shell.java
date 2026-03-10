/* Ordenamiento Shell (Shell Sort)

Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de 
forma más eficiente que el método de burbuja o inserción simple.
Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de 
N/2
. El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la 
inserción simple al trabajar con elementos que están muy lejos de su posición final.
Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas
las fases de reducción de saltos.
 */

import java.util.Scanner;

public class E3_Salto_de_Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos paquetes deseas ordenar? (recomendado: 10 o más): ");
        int n = scanner.nextInt();

        while (n < 2) {
            System.out.print("Ingresa al menos 2 paquetes: ");
            n = scanner.nextInt();
        }

        double[] pesos = new double[n];

        System.out.println("\nIngresa el peso de cada paquete (en kg):");
        for (int i = 0; i < n; i++) {
            System.out.print("  Paquete " + (i + 1) + ": ");
            pesos[i] = scanner.nextDouble();
        }

        double[] original = pesos.clone();

        System.out.println("\n--- Proceso Shell Sort ---");
        System.out.print("Arreglo original: ");
        imprimirArreglo(pesos);
        System.out.println();

        int gap = n / 2;
        int fase = 1;

        while (gap > 0) {
            System.out.println("\nFase " + fase + " (gap = " + gap + "):");

            for (int i = gap; i < n; i++) {
                double temp = pesos[i];
                int j = i;

                while (j >= gap && pesos[j - gap] > temp) {
                    pesos[j] = pesos[j - gap];
                    j -= gap;
                }

                pesos[j] = temp;
            }

            System.out.print("  Estado: ");
            imprimirArreglo(pesos);
            System.out.println();

            gap /= 2;
            fase++;
        }

        System.out.print("\nArreglo original: ");
        imprimirArreglo(original);
        System.out.println();

        System.out.print("Arreglo ordenado: ");
        imprimirArreglo(pesos);
        System.out.println("\nPaquetes ordenados de menor a mayor peso.");

        scanner.close();
    }

    static void imprimirArreglo(double[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
}
