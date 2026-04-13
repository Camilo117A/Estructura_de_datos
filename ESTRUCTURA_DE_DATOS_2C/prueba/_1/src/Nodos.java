/* Reto 2: Contar los Nodos
A diferencia de los arreglos, que tienen la propiedad .length, en las listas enlazadas simples por lo general 
no sabemos la cantidad de elementos a menos que la contemos, o que llevemos una variable contadora.

Tu misión: Implementa el método public int contarNodos() en tu clase ListaEnlazada. Este método debe recorrer 
toda la lista, sumando 1 por cada nodo que visite, y retornar el total de elementos. Pruébalo en tu método main 
insertando diferentes cantidades de elementos y mostrando el resultado por consola.
 */
public class Nodos {

    int contadorNodos;
    String sigiente;

    public Nodos(int contadorNodos, String sigiente){
        this.contadorNodos = contadorNodos;
        this.sigiente = sigiente;
    }
}
