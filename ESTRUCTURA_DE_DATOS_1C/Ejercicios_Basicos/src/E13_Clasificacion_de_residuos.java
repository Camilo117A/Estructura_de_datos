/* Ejercicio 13 — Clasificación de residuos (no lineal)
Modela una jerarquía de tipos de residuos con una estructura de árbol usando nodos:

        Residuos
       /        \
  Orgánicos   Inorgánicos
   /    \       /      \
Comida Jardín Plástico Papel
Crea la clase NodoResiduo con un campo nombre y referencias izquierdo y derecho.
Construye el árbol mostrado.
Imprime la raíz y todos sus descendientes indicando el nivel. */

public class E13_Clasificacion_de_residuos {
    static class Nodo_Residuo {
        String nombre;
        Nodo_Residuo izquierdo;
        Nodo_Residuo derecho;

        Nodo_Residuo(String nombre) {
            this.nombre = nombre;
        }
    }

    static void imprimir_Arbol(Nodo_Residuo nodo, int nivel) {
        if (nodo == null) return;
        System.out.println("Nivel " + nivel + ": " + nodo.nombre);
        imprimir_Arbol(nodo.izquierdo, nivel + 1);
        imprimir_Arbol(nodo.derecho, nivel + 1);
    }

    public static void main(String[] args) {

        Nodo_Residuo raiz         = new Nodo_Residuo("Residuos");
        raiz.izquierdo            = new Nodo_Residuo("Organicos");
        raiz.derecho              = new Nodo_Residuo("Inorganicos");
        raiz.izquierdo.izquierdo  = new Nodo_Residuo("Comida");
        raiz.izquierdo.derecho    = new Nodo_Residuo("Jardin");
        raiz.derecho.izquierdo    = new Nodo_Residuo("Plastico");
        raiz.derecho.derecho      = new Nodo_Residuo("Papel");

        imprimir_Arbol(raiz, 0);
    }
}
