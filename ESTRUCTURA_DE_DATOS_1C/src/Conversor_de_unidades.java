//Ejercicio 5 — Conversor de unidades
//Una aplicación de cocina necesita convertir unidades:

//Declara una variable tazas (double) con la cantidad de tazas de un ingrediente.
//Convierte a mililitros (1 taza = 236.588 ml) y guarda el resultado en otra variable.
//Convierte también a litros.
//Muestra las tres medidas por consola.

public class Conversor_de_unidades {
    public static void main(String[] args) {
        // Variable inicial
        double cantidadTazas = 2.5;
        
        // Constante de conversión
        final double ML_POR_TAZA = 236.588;

        // Cálculos
        double total_ML = cantidadTazas * ML_POR_TAZA;
        double total_L = total_ML / 1000;

        // Resultados
        System.out.println("=== Conversor de Medidas ===");
        System.out.println("Medida original: " + cantidadTazas + " tazas");
        System.out.println("Equivalente en Mililitros: " + total_ML + " ml");
        System.out.println("Equivalente en Litros: " + total_L + " L");
    }
}
