//Ejercicio 11 — Lista de pasajeros (lineal)
//Una aerolínea registra los nombres de los pasajeros de un vuelo en un arreglo de String con capacidad para 6 personas.

//Llena el arreglo con nombres.
//Recórrelo con un for e imprime el número de asiento y el nombre.
//Muestra cuántos asientos están ocupados.


public class E11_Lista_de_pasajeros {
    public static void main(String[] args) {

        String[] pasajeros = {"Carlos", "Maria", "Juan", "Ana", "Pedro", "Laura"};
        int asientos_Ocupados = 0;

        for (int i = 0; i < pasajeros.length; i++) {
            System.out.println("Asiento " + (i + 1) + ": " + pasajeros[i]);
            asientos_Ocupados++;
        }

        System.out.println("\nAsientos ocupados: " + asientos_Ocupados);
    }
}