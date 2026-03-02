//Ejercicio 9 — Notas de un curso
//Un profesor tiene las notas de 4 estudiantes en un arreglo. El coordinador recibe una referencia al mismo arreglo para revisarlas.

//El coordinador corrige la nota del estudiante 2 (índice 1) de 2.5 a 3.0.
//Muestra que el arreglo del profesor también refleja el cambio.
//Añade comentarios explicando el concepto de referencia en memoria.

public class Notas_de_un_curso {
    public static void main(String[] args) {

        double[] notas_Profesor = {4.5, 2.5, 3.8, 4.0};
        double[] notas_Coordinador = notas_Profesor;

        System.out.println("Nota estudiante 2 antes: " + notas_Profesor[1]);

        notas_Coordinador[1] = 3.0;

        System.out.println("Nota estudiante 2 despues: " + notas_Profesor[1]);
    }
}
