public class CalculadoraTienda {
    public static void main(String[] args) {
        // Datos de entrada
        double precioUnitario = 1500.0;
        int cantidadComprada = 5;
        double descuentoPorcentaje = 10.0;

        // Procesamiento de datos
        double subtotal = precioUnitario * cantidadComprada;
        double descuentoCalculado = subtotal * (descuentoPorcentaje / 100);
        double totalFinal = subtotal - descuentoCalculado;

        // Salida de resultados
        System.out.println("=== Detalle de Compra ===");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (" + descuentoPorcentaje + "%): $" + descuentoCalculado);
        System.out.println("Total a pagar: $" + totalFinal);
    }
}
