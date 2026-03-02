//Ejercicio 12 — Historial de ventas (lineal)
//Una tienda online guarda las ventas del día en un arreglo de double:

//Almacena 7 ventas de ejemplo.
//Calcula e imprime: la venta más alta, la venta más baja y el total del día.

public class E12_Historial_de_ventas {
    public static void main(String[] args) {

        double[] ventas = {150.5, 200.0, 80.3, 320.7, 95.0, 410.2, 175.8};

        double venta_Mas_Alta = ventas[0];
        double venta_Mas_Baja = ventas[0];
        double total_Dia = 0;

        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] > venta_Mas_Alta) venta_Mas_Alta = ventas[i];
            if (ventas[i] < venta_Mas_Baja) venta_Mas_Baja = ventas[i];
            total_Dia += ventas[i];
        }

        System.out.println("Venta mas alta: $" + venta_Mas_Alta);
        System.out.println("Venta mas baja: $" + venta_Mas_Baja);
        System.out.println("Total del dia:  $" + total_Dia);
    }
}
