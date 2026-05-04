// ============================================================
//  LISTA CIRCULAR — TODOS LOS PATRONES
//  Regla de oro: cola.siguiente == cabeza SIEMPRE
// ============================================================

public class ListaCircular {

    NodoCircular cabeza;    // primer nodo
    NodoCircular cola;      // último nodo (su .siguiente apunta a cabeza)
    int cantidad;           // muchos ejercicios llevan contador

    public ListaCircular() {
        this.cabeza   = null;
        this.cola     = null;
        this.cantidad = 0;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 1 — AGREGAR (siempre igual en todos tus ejercicios)
    //  Este código es IDÉNTICO en sorteo, carrusel, round robin,
    //  restaurante y torneo — solo cambia el nombre de la clase
    // ══════════════════════════════════════════════════════
    public void agregar(NodoCircular nuevo) {
        if (cabeza == null) {
            // primer nodo: apunta a sí mismo
            cabeza           = nuevo;
            cola             = nuevo;
            nuevo.siguiente  = cabeza;   // ← forma el ciclo con 1 solo nodo
        } else {
            cola.siguiente   = nuevo;    // vieja cola → nuevo
            nuevo.siguiente  = cabeza;   // nuevo → cabeza (cierra el círculo)
            cola             = nuevo;    // nuevo ES la nueva cola
        }
        cantidad++;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 2 — RECORRER CON do-while (NO usar while)
    //  Si usas while(temp != cabeza) con temp = cabeza, nunca entra
    // ══════════════════════════════════════════════════════
    public void mostrar() {
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        NodoCircular temp = cabeza;
        do {
            System.out.println(temp.nombre);
            temp = temp.siguiente;
        } while (temp != cabeza);        // para cuando vuelves al inicio
    }

    // Recorrer N ciclos completos (usado en carrusel):
    public void reproducirNCiclos(int ciclos) {
        if (cabeza == null) return;
        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {
            System.out.println("-- Ciclo " + ciclo + " --");
            NodoCircular temp = cabeza;
            do {
                // procesa cada nodo del ciclo
                System.out.println(temp.nombre);
                temp.cantidad++;          // ej: contar repeticiones
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 3 — AVANZAR N PASOS (sorteo/ruleta)
    //  La circularidad garantiza que nunca llega a null
    // ══════════════════════════════════════════════════════
    public void avanzarNPasos(int pasos) {
        if (cabeza == null) { System.out.println("Sin participantes"); return; }
        NodoCircular actual = cabeza;
        for (int i = 0; i < pasos; i++) {
            actual = actual.siguiente;   // nunca null: da la vuelta si hace falta
        }
        System.out.println("Seleccionado: " + actual.nombre);
        eliminar(actual);                // en sorteo: elimina al ganador
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 4 — ELIMINAR UN NODO
    //  Clave: siempre mantener cola.siguiente == cabeza
    // ══════════════════════════════════════════════════════
    public void eliminar(NodoCircular nodo) {
        if (cabeza == null || nodo == null) return;

        // Caso 1: es el único nodo
        if (cabeza == cola) {
            cabeza = null; cola = null; cantidad--; return;
        }

        // Caso 2: es la cabeza
        if (nodo == cabeza) {
            cabeza          = cabeza.siguiente;
            cola.siguiente  = cabeza;    // ← re-cierra el círculo con nueva cabeza
            cantidad--;
            return;
        }

        // Caso 3: buscar el anterior para desconectar
        NodoCircular anterior = cabeza;
        while (anterior.siguiente != nodo) {
            anterior = anterior.siguiente;
        }
        anterior.siguiente = nodo.siguiente; // salta al eliminado

        if (nodo == cola) {
            cola = anterior;             // si era la cola, actualizar cola
            // cola.siguiente sigue siendo cabeza — ya está correcto
        }
        cantidad--;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 5 — MOVER CABEZA AL FINAL (clientes VIP)
    //  Usado en: restaurante (grupo VIP vuelve al final de la fila)
    // ══════════════════════════════════════════════════════
    public void moverCabezaAlFinal() {
        if (cabeza == null || cabeza == cola) return; // 0 o 1 nodo

        NodoCircular antiguo = cabeza;
        cabeza          = cabeza.siguiente;  // la cabeza avanza
        cola.siguiente  = antiguo;           // vieja cabeza va después de la cola
        cola            = antiguo;           // vieja cabeza ES la nueva cola
        cola.siguiente  = cabeza;            // re-cierra el círculo
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 6 — ROUND ROBIN (el más difícil)
    //  Dos punteros: actual (el que procesas) + anterior (para eliminar)
    // ══════════════════════════════════════════════════════
    public void roundRobin(int quantum) {
        if (cabeza == null) { System.out.println("Sin procesos"); return; }

        NodoCircular actual   = cabeza;
        NodoCircular anterior = cola;    // empieza apuntando al último

        while (cantidad > 0) {
            actual.cantidad -= quantum;  // resta el quantum al tiempo restante

            if (actual.cantidad <= 0) {
                // TERMINÓ — eliminar actual
                System.out.println(actual.nombre + " terminó");

                if (cantidad == 1) {
                    cabeza = null; cola = null; cantidad--; break;
                }

                if (actual == cabeza) {
                    cabeza         = cabeza.siguiente;
                    cola.siguiente = cabeza;
                    actual         = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente; // salta al eliminado
                    if (actual == cola) cola = anterior;
                    actual = anterior.siguiente;
                }
                cantidad--;
            } else {
                // NO terminó — pasar al siguiente
                System.out.println(actual.nombre + " restante: " + actual.cantidad);
                anterior = actual;
                actual   = actual.siguiente;
            }
        }
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 7 — BUSCAR EL MÁXIMO EN CIRCULAR
    // ══════════════════════════════════════════════════════
    public NodoCircular buscarMaximo() {
        if (cabeza == null) return null;
        NodoCircular temp   = cabeza;
        NodoCircular maximo = cabeza;
        do {
            if (temp.cantidad > maximo.cantidad) maximo = temp;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return maximo;
    }
}
