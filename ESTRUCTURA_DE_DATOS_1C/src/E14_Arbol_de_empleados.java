/* Ejercicio 14 — Árbol de empleados (no lineal)
Una empresa tiene la siguiente jerarquía:

         Gerente
        /       \
   Supervisor1  Supervisor2
    /      \
 Analista1 Analista2
Modela la jerarquía con nodos que tengan el campo cargo.
Imprime el árbol recorriéndolo nivel por nivel. */

import java.util.LinkedList;
import java.util.Queue;

public class E14_Arbol_de_empleados {
    static class Nodo_Empleado {
        String cargo;
        Nodo_Empleado izquierdo, derecho;

        Nodo_Empleado(String cargo) { this.cargo = cargo; }
    }

    public static void main(String[] args) {

        Nodo_Empleado raiz       = new Nodo_Empleado("Gerente");
        raiz.izquierdo           = new Nodo_Empleado("Supervisor1");
        raiz.derecho             = new Nodo_Empleado("Supervisor2");
        raiz.izquierdo.izquierdo = new Nodo_Empleado("Analista1");
        raiz.izquierdo.derecho   = new Nodo_Empleado("Analista2");

        Queue<Nodo_Empleado> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 0;

        while (!cola.isEmpty()) {
            int cantidad = cola.size();
            System.out.print("Nivel " + nivel + ": ");
            for (int i = 0; i < cantidad; i++) {
                Nodo_Empleado actual = cola.poll();
                System.out.print(actual.cargo + " ");
                if (actual.izquierdo != null) cola.add(actual.izquierdo);
                if (actual.derecho   != null) cola.add(actual.derecho);
            }
            System.out.println();
            nivel++;
        }
    }
}
