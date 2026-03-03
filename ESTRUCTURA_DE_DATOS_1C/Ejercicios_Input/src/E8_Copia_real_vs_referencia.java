/* Ejercicio 8 — Copia real vs referencia
Pide al usuario 3 calificaciones para llenar notas[]. Crea una copia real en notasRespaldo[] copiando elemento por elemento. Modifica notas[0] con un valor que el usuario ingrese. Muestra ambos arreglos y verifica que notasRespaldo no cambió.

Datos de entrada: double × 3 notas, double nuevo valor para notas[0]

Salida esperada:

notas[0]         = 4.5  ← cambió
notasRespaldo[0] = 3.2  ← no cambió, es una copia independiente
 */

import java.util.Scanner;

public class E8_Copia_real_vs_referencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] notas = new double[3];

        System.out.println("Ingresa 3 calificaciones:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("  Nota [" + i + "]: ");
            notas[i] = sc.nextDouble();
        }

        double[] notasRespaldo = new double[notas.length];
        for (int i = 0; i < notas.length; i++) {
            notasRespaldo[i] = notas[i]; 
        }

        System.out.print("\nIngresa el nuevo valor para notas[0]: ");
        double nuevoValor = sc.nextDouble();
        notas[0] = nuevoValor;

        System.out.println("\n--- Resultado ---");
        System.out.printf("notas[0]         = %.1f  cambió%n",           notas[0]);
        System.out.printf("notasRespaldo[0] = %.1f  no cambió, es una copia independiente%n",notasRespaldo[0]);

        sc.close();
    }
}
