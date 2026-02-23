package Ejercicios_basicos;

public class ConversorCocina {
    public static void main(String[] args) {
        // Variable inicial
        double cantidadTazas = 2.5;
        
        // Constante de conversión
        final double ML_POR_TAZA = 236.588;

        // Cálculos
        double totalMililitros = cantidadTazas * ML_POR_TAZA;
        double totalLitros = totalMililitros / 1000;

        // Resultados
        System.out.println("=== Conversor de Medidas ===");
        System.out.println("Medida original: " + cantidadTazas + " tazas");
        System.out.println("Equivalente en Mililitros: " + totalMililitros + " ml");
        System.out.println("Equivalente en Litros: " + totalLitros + " L");
    }
}
