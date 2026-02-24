//Ejercicio 2 — Calculadora de una tienda
//Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

//Precio unitario de un producto (double)
//Cantidad comprada (int)
//Descuento aplicado en porcentaje (double)
//Total a pagar después del descuento
//Declara las variables, realiza el cálculo y muestra el resultado por consola.

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
