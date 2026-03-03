    /* Ejercicio 10 — Intercambio de valores
    Pide dos números enteros x e y. Intercambia sus valores usando una variable auxiliar temp. Muestra los valores antes y después del intercambio.

    Datos de entrada: int x, int y

    Salida esperada:

    Antes  → x=5, y=8
    Después→ x=8, y=5
    Pista: Si asignas x = y directamente sin temp, pierdes el valor original de x. */

import java.util.Scanner;

public class E10_Intercambio_de_valores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número (x): ");
        int x = sc.nextInt();

        System.out.print("Introduce el segundo número (y): ");
        int y = sc.nextInt();

        System.out.println("\nAntes  → x=" + x + ", y=" + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("Después→ x=" + x + ", y=" + y);

        sc.close();
    }
}
