/* Ejercicio 1 — Recibo de compra
Pide al usuario el nombre de un producto, la cantidad comprada y el precio unitario. Calcula el subtotal, aplica un IVA del 19% y muestra el recibo con el total a pagar.

Datos de entrada:

String nombre del producto
int cantidad
double precio unitario
Salida esperada:

===== Recibo =====
Producto  : Arroz
Cantidad  : 3
Precio c/u: $2500.00
Subtotal  : $7500.00
IVA (19%) : $1425.00
Total     : $8925.00 */

import java.util.Scanner;

public class E1_Recibo_de_compra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del producto : ");
        String producto = sc.nextLine();

        System.out.print("Cantidad comprada   : ");
        int cantidad = sc.nextInt();

        System.out.print("Precio unitario ($) : ");
        double precioUnitario = sc.nextDouble();

        double subtotal = cantidad * precioUnitario;
        double iva      = subtotal * 0.19;       
        double total    = subtotal + iva;     

        System.out.println("\n===== Recibo =====");
        System.out.printf("Producto  : %s%n",     producto);
        System.out.printf("Cantidad  : %d%n",     cantidad);
        System.out.printf("Precio c/u: $%.2f%n",  precioUnitario);
        System.out.printf("Subtotal  : $%.2f%n",  subtotal);
        System.out.printf("IVA (19%%): $%.2f%n",  iva);
        System.out.printf("Total     : $%.2f%n",  total);

        sc.close();
    }
}
