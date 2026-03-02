//Ejercicio 6 — Turno en un banco
//Un cajero de banco trabaja con el número del turno actual. Se crea una variable turnoActual y se asigna a turnoEnPantalla.

//Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
//Explica en un comentario por qué ocurre esto.

public class Turno_en_un_banco {
    public static void main(String[] args) {

        int turno_Actual = 15;
        int turno_En_Pantalla = turno_Actual;

        System.out.println("Turno actual: " + turno_Actual);
        System.out.println("Turno en pantalla: " + turno_En_Pantalla);

        turno_En_Pantalla = 99;

        System.out.println("\nTurno actual: " + turno_Actual);
        System.out.println("Turno en pantalla: " + turno_En_Pantalla);
    }
}