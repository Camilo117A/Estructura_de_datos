//Ejercicio 7 — Inventario compartido
//Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

//Crea el arreglo stockAlmacen con valores iniciales.
//Asigna stockReportes = stockAlmacen.
//Simula una venta reduciendo el stock de un producto desde stockReportes.
//Muestra que stockAlmacen también cambió y explica en comentarios por qué.

public class Inventari_compartido {
    public static void main(String[] args) {

        int[] stock_Almacen = {100, 50, 75, 30, 60};
        int[] stock_Reportes = stock_Almacen;

        System.out.println("Stock almacen antes de la venta: ");
        for (int stock : stock_Almacen) {
            System.out.print(stock + " ");
        }

        // Se simula una venta, se reduce el stock del producto 1
        stock_Reportes[0] = 80;

        System.out.println("\n\nStock almacen despues de la venta: ");
        for (int stock : stock_Almacen) {
            System.out.print(stock + " ");
        }
    }
}
