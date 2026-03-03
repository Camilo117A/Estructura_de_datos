/* Sensor de Temperatura (Control de Calidad)
Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de que la máquina no se recalentó.
Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos. */

public class E3_Sensor_de_Temperatura {
    public static void main(String[] args) {
        double[] temperaturas = {75.5, 80.2, 78.9, 82.1, 79.0, 81.3};

        double temperaturaMaxima = temperaturas[0];

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i];
            }
        }

        System.out.printf("La temperatura más alta registrada fue: %.1f°C%n", temperaturaMaxima);
    }
}