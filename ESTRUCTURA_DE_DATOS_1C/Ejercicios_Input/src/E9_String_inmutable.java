/* Ejercicio 9 — String inmutable
Pide al usuario su nombre. Asigna alias = nombre. Pide un nuevo alias. Muestra que nombre no cambió y explica la inmutabilidad de String con un mensaje en consola.

Datos de entrada: String nombre, String nuevo alias */

import java.util.Scanner;

public class E9_String_inmutable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        String alias = nombre;

        System.out.println("Nombre: " + nombre);
        System.out.println("Alias: " + alias);

        System.out.print("Introduce un nuevo alias: ");
        alias = sc.nextLine();

        System.out.println("\nDespués de cambiar alias:");
        System.out.println("Nombre: " + nombre + "  no cambió");
        System.out.println("Alias: " + alias + "  cambió");

        sc.close();
    }
}
