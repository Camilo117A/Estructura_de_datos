/* Ejercicio 7 — Arreglo compartido (inventario)
Pide al usuario 4 precios para llenar un arreglo precios[]. Crea preciosAuditoria = precios (misma referencia). Pide al usuario el índice y el nuevo precio para hacer una corrección desde preciosAuditoria. Muestra ambos arreglos y verifica que el cambio se refleja en los dos.

Datos de entrada: double × 4 precios, int índice, double nuevo precio */

import java.util.Scanner;

public class E7_Arreglo_compartido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] precios = new double[4];
        for (int i = 0; i < precios.length; i++) {
            System.out.printf("Precio %d: ", i);
            precios[i] = sc.nextDouble();
        }

        double[] preciosAuditoria = precios;

        System.out.println("\n--- Precios ---");
        for (int i = 0; i < precios.length; i++) {
            System.out.printf("precios[%d] = %.2f%n", i, precios[i]);
        }
        System.out.println("");

        System.out.print("Índice a corregir (0-3): ");
        int indice = sc.nextInt();

        System.out.print("Nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();

        preciosAuditoria[indice] = nuevoPrecio;

        System.out.println("\n--- Precios Auditoría ---");
        for (int i = 0; i < preciosAuditoria.length; i++) {
            System.out.printf("preciosAuditoria[%d] = %.2f%n", i, preciosAuditoria[i]);
        }

        sc.close();
    }
}
