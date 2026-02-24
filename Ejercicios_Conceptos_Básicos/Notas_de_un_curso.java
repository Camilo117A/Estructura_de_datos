public class Notas_de_un_curso {
    public static void main(String[] args) {

        double[] notas_Profesor = {4.5, 2.5, 3.8, 4.0};
        double[] notas_Coordinador = notas_Profesor;

        System.out.println("Nota estudiante 2 antes: " + notas_Profesor[1]);

        notas_Coordinador[1] = 3.0;

        System.out.println("Nota estudiante 2 despues: " + notas_Profesor[1]);
    }
}
