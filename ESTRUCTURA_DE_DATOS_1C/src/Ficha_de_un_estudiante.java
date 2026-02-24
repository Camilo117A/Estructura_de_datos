//Ejercicio 1 — Ficha de un estudiante
//Un sistema universitario necesita registrar la información básica de un estudiante: nombre completo, código (número entero), semestre actual, promedio acumulado y si está matriculado o no.

//Declara las variables con los tipos de datos apropiados.
//Asigna valores de ejemplo.
//Imprime un reporte por consola con el siguiente formato:
//=== Ficha del Estudiante ===
//Nombre: Ana Torres
//Código: 20241001
//Semestre: 3
//Promedio: 3.85
//Matriculado: true


public class Ficha_de_un_estudiante {
    public static void main(String[] args) {
        // Declaración de variables con tipos adecuados
        String nombre = "Ana Torres";
        int codigo_E = 20241001;
        int semestre = 3;
        double promedio = 3.85;
        boolean Matriculado = true;

        // Impresión del reporte con formato limpio
        System.out.println("=== Ficha del Estudiante ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo_E);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + Matriculado);
    }
}
