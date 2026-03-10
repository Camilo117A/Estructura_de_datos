/* Ordenamiento por Inserción (Insertion Sort)

Contexto: Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el 
estante en su posición correcta.
Detalle del ejercicio: El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) de cada uno.
Lógica de Inserción: A medida que el usuario ingresa un número, o una vez llenado el arreglo, 
el algoritmo debe simular el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
Visualización Paso a Paso: En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando 
el arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30]). Esto permite al estudiante ver cómo los elementos 
se desplazan para abrir espacio al nuevo valor. */

import java.util.Scanner;

public class E2_Organización_de_Biblioteca_Dinámica {
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

        System.out.print("Cuántos libros deseas ingresar: ");
        int n = scanner.nextInt();

        while (n < 1) {
            System.out.print("Ingresa al menos 1 libro: ");
            n = scanner.nextInt();
        }

        int[] isbn = new int[n];

        System.out.println("\nIngresa el código ISBN de cada libro:");
        for (int i = 0; i < n; i++) {
            System.out.print("  ISBN libro " + (i + 1) + ": ");
            isbn[i] = scanner.nextInt();
            int clave = isbn[i];
            int j = i - 1;

            System.out.println("\nPaso " + i + ": Insertando ISBN " + clave);
            System.out.print("  Antes:   ");
            imprimirArreglo(isbn);
            System.out.println();
    
            while (j >= 0 && isbn[j] > clave) {
                isbn[j + 1] = isbn[j];
                j--;
            }
    
            isbn[j + 1] = clave;
    
            System.out.print("  Despues: ");
            imprimirArreglo(isbn);
            System.out.println();
        }

        System.out.print("\nArreglo original: ");
        imprimirArreglo(isbn);
        System.out.println();

        System.out.println("\n--- Proceso de Insertion Sort paso a paso ---");

        System.out.print("\nArreglo final ordenado: ");
        imprimirArreglo(isbn);
        System.out.println("\nLibros ordenados por código ISBN de menor a mayor.");

        scanner.close();
    }
}
