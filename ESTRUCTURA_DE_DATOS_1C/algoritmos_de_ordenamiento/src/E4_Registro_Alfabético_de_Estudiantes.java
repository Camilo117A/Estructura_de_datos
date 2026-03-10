/* Ordenamiento por Inserción (Insertion Sort)

Contexto: El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el 
sistema se ordene alfabéticamente de la A a la Z.
Detalle del ejercicio: El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenas de texto).
Lógica de Texto: Se debe usar el método de Inserción adaptado para String.
Requisito técnico: El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2). 
Es vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
Resultado esperado: La lista de asistencia impresa en orden alfabético perfecto.
 */

import java.util.Scanner;

public class E4_Registro_Alfabético_de_Estudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos alumnos hay en clase? ");
        int n = scanner.nextInt();

        while (n < 1) {
            System.out.print("Debe haber al menos 1 alumno: ");
            n = scanner.nextInt();
        }

        String[] nombres = new String[n];
        scanner.nextLine();

        System.out.println("\nIngresa los nombres de los alumnos:");
        for (int i = 0; i < n; i++) {
            System.out.print("  Alumno " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine().trim();
        }

        System.out.println("\n--- Lista original ingresada ---");
        for (int i = 0; i < n; i++) {
            System.out.println("  " + (i + 1) + ". " + nombres[i]);
        }

        for (int i = 1; i < n; i++) {
            String clave = nombres[i]; 
            int j = i - 1;

            while (j >= 0 && nombres[j].compareToIgnoreCase(clave) > 0) {
                nombres[j + 1] = nombres[j]; 
                j--;
            }

            nombres[j + 1] = clave; 
        }

        System.out.println("\n--- Lista de asistencia (orden alfabético) ---");
        for (int i = 0; i < n; i++) {
            System.out.println("  " + (i + 1) + ". " + nombres[i]);
        }
        
        scanner.close();
    }
}
