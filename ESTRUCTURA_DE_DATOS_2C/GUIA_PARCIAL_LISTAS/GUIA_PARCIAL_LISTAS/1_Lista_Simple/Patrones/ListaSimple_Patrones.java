// ============================================================
//  LISTA SIMPLE — TODOS LOS PATRONES
//  Cada método tiene comentarios explicando qué hace cada línea
// ============================================================

public class ListaSimple_Patrones {

    Nodo cabeza;   // primer nodo de la lista
    Nodo cola;     // último nodo (no siempre se usa, depende del ejercicio)

    public ListaSimple_Patrones() {
        this.cabeza = null;  // siempre empieza vacía
        this.cola   = null;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 1 — AGREGAR AL FINAL
    //  Usado en: tren, vuelos, playlist, inventario (sin urgencia)
    // ══════════════════════════════════════════════════════
    public void agregarAlFinal(Nodo nuevo) {
        if (cabeza == null) {
            // lista vacía: el nuevo es el único nodo
            cabeza = nuevo;
        } else {
            // recorre hasta llegar al último nodo
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            // enlaza el nuevo al final
            actual.siguiente = nuevo;
        }
    }
    // NOTA: si tu lista tiene puntero 'cola', puedes hacer esto en O(1):
    //   cola.siguiente = nuevo;
    //   cola = nuevo;


    // ══════════════════════════════════════════════════════
    //  PATRÓN 2 — AGREGAR AL INICIO
    //  Usado en: sensores (más reciente primero), inventario urgente
    // ══════════════════════════════════════════════════════
    public void agregarAlInicio(Nodo nuevo) {
        nuevo.siguiente = cabeza;  // nuevo apunta a quien era la cabeza
        cabeza = nuevo;            // nuevo PASA A SER la cabeza
        // solo 2 líneas — no necesita recorrer la lista
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 3 — AGREGAR EN MEDIO (después de un nodo)
    //  Usado en: playlist (agregar a continuación de la canción actual)
    // ══════════════════════════════════════════════════════
    public void agregarDespuesDe(Nodo nodoActual, Nodo nuevo) {
        // ORDEN IMPORTA: primero enlazar el nuevo, luego actualizar el actual
        nuevo.siguiente      = nodoActual.siguiente; // 1° nuevo apunta al siguiente
        nodoActual.siguiente = nuevo;                // 2° actual apunta al nuevo
        // Si lo haces al revés, pierdes la referencia al resto de la lista
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 4 — AGREGAR CONDICIONAL
    //  Usado en: inventario (inicio si vence pronto, final si no)
    // ══════════════════════════════════════════════════════
    public void agregarCondicional(Nodo nuevo, boolean condicionDeInicio) {
        if (condicionDeInicio) {
            // va al inicio (ej: dias < 3, urgencia alta)
            agregarAlInicio(nuevo);
        } else {
            // va al final (caso normal)
            agregarAlFinal(nuevo);
        }
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 5 — RECORRER Y MOSTRAR
    //  Base de casi todos los métodos
    // ══════════════════════════════════════════════════════
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.nombre);  // imprime lo que necesites
            actual = actual.siguiente;          // avanza al siguiente
        }
        // Al terminar el while, actual == null (llegamos al final)
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 6 — BUSCAR EL MÁXIMO (o mínimo)
    //  Usado en: sensores (temperatura más alta)
    // ══════════════════════════════════════════════════════
    public Nodo buscarMaximo() {
        if (cabeza == null) return null;

        Nodo actual = cabeza;
        Nodo maximo = cabeza;        // asume que el primero es el mayor

        while (actual != null) {
            if (actual.cantidad > maximo.cantidad) {
                maximo = actual;     // encontró uno mayor, actualiza
            }
            actual = actual.siguiente;
        }
        return maximo;               // devuelve el nodo con el valor más alto
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 7 — BUSCAR POR CAMPO
    //  Usado en: vuelos (buscar por numero de vuelo)
    // ══════════════════════════════════════════════════════
    public Nodo buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {  // usa .equals() para Strings
                return actual;                    // encontrado
            }
            actual = actual.siguiente;
        }
        return null;  // no encontrado
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 8 — MOVER UN NODO AL INICIO (emergencia)
    //  Usado en: vuelos (reportarEmergencia)
    // ══════════════════════════════════════════════════════
    public void moverAlInicio(String nombre) {
        // si ya es la cabeza, no hay nada que hacer
        if (cabeza == null || cabeza.nombre.equals(nombre)) return;

        Nodo anterior = cabeza;
        Nodo actual   = cabeza.siguiente;

        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                anterior.siguiente = actual.siguiente; // salta al encontrado
                actual.siguiente   = cabeza;           // encontrado → vieja cabeza
                cabeza             = actual;           // encontrado ES la nueva cabeza
                return;
            }
            anterior = actual;
            actual   = actual.siguiente;
        }
        System.out.println("No se encontró: " + nombre);
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 9 — SUMAR UN CAMPO (total)
    //  Usado en: tren (peso total), playlist (tiempo total)
    // ══════════════════════════════════════════════════════
    public int calcularTotal() {
        int total  = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            total  += actual.cantidad;       // suma el campo que necesites
            actual  = actual.siguiente;
        }
        return total;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 10 — FILTRAR (mostrar solo los que cumplen)
    //  Usado en: inventario (mostrar próximos a vencer)
    // ══════════════════════════════════════════════════════
    public void filtrar(int limite) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.cantidad < limite) {       // tu condición de filtro
                System.out.println(actual.nombre);
            }
            actual = actual.siguiente;
        }
    }
}
