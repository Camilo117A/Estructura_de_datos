public class Calculadora_de_una_tienda {
    public static void main(String[] args) {
        // Datos de entrada
        double precio_U = 1500.0;
        int cantidad_C = 5;
        double descuento_P = 10.0;

        // Procesamiento de datos
        double subtotal = precio_U * cantidad_C;
        double descuentoCalculado = subtotal * (descuento_P / 100);
        double totalFinal = subtotal - descuentoCalculado;

        // Salida de resultados
        System.out.println("=== Detalle de Compra ===");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (" + descuento_P + "%): $" + descuentoCalculado);
        System.out.println("Total a pagar: $" + totalFinal);
    }
}
