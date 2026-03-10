/* Ordenamiento por Selección (Selection Sort)

Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénes ganaron las medallas.
Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debe pedir el tiempo en segundos (con decimales) de cada corredor.
Lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo al inicio.
Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar un mensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar).
 */

import java.util.Scanner;

public class E1_Podio_de_la_Competencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos corredores participaron? (entre 5 y 10): ");
        int n = scanner.nextInt();

        while (n < 5 || n > 10) {
            System.out.print("Por favor ingresa un número entre 5 y 10: ");
            n = scanner.nextInt();
        }

        double[] tiempos = new double[n];
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tiempo de corredor " + (i + 1) + " (en segundos): ");
            tiempos[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.println("\n--- Tiempos ingresados ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Corredor %d: %.2f s%n", (i + 1), tiempos[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (tiempos[j] < tiempos[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            double tempTiempo = tiempos[i];
            tiempos[i] = tiempos[indiceMenor];
            tiempos[indiceMenor] = tempTiempo;

        }

        System.out.println("\n--- Resultados finales ordenados ---");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". Corredor " + (i + 1) + " - " + tiempos[i]);
        }

        System.out.println("\n🏆 === PODIO OFICIAL ===");
        System.out.printf("🥇 ORO   → Corredor %d (%.2f s)%n", 1, tiempos[0]);
        System.out.printf("🥈 PLATA → Corredor %d (%.2f s)%n", 2    , tiempos[1]);
        System.out.printf("🥉 BRONCE→ Corredor %d (%.2f s)%n", 3, tiempos[2]);

        scanner.close();
    }
}