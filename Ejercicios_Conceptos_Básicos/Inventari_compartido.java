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
