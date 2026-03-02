/* Ejercicio 15 — Registro de temperaturas semanales (lineal)
Una estación meteorológica registra la temperatura máxima de cada día de la semana en un arreglo.

Llena el arreglo con 7 valores.
Calcula el promedio semanal.
Indica qué días estuvieron por encima del promedio. */

public class E15_Registro_de_temperaturas_semanales {
    public static void main(String[] args) {

        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        double[] temperaturas = {28.5, 30.0, 26.3, 31.2, 29.8, 33.0, 27.5};

        double suma = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }

        double promedio = suma / temperaturas.length;
        System.out.println("Promedio semanal: " + promedio + "°C\n");

        System.out.println("Dias por encima del promedio:");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println("  " + dias[i] + ": " + temperaturas[i] + "°C");
            }
        }
    }
}