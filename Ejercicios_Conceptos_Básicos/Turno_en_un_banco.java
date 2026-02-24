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