// ============================================================
//  LISTA CIRCULAR DOBLE — TODOS LOS PATRONES
//  Regla de oro: siempre hay nodo siguiente y anterior — NUNCA null
// ============================================================

public class ListaCircularDoble {

    NodoCircularDoble cabeza;
    NodoCircularDoble cola;
    NodoCircularDoble actual;   // cursor de navegación
    int cantidad;

    public ListaCircularDoble() {
        this.cabeza   = null;
        this.cola     = null;
        this.actual   = null;
        this.cantidad = 0;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 1 — AGREGAR (actualizar 4 punteros)
    //  Este código es IDÉNTICO en metro, terminal, editor y galería
    //  Es el más punteros tiene pero sigue orden fijo: cola→nueva←cola nueva→cabeza←nueva
    // ══════════════════════════════════════════════════════
    public void agregar(NodoCircularDoble nueva) {
        if (cabeza == null) {
            // primer nodo: apunta a sí mismo en ambas direcciones
            nueva.siguiente = nueva;    // → sí misma
            nueva.anterior  = nueva;    // ← sí misma
            cabeza = nueva;
            cola   = nueva;
            actual = nueva;
        } else {
            // Siempre este orden de 4 pasos:
            cola.siguiente   = nueva;   // 1. vieja cola → nueva
            nueva.anterior   = cola;    // 2. nueva ← vieja cola
            nueva.siguiente  = cabeza;  // 3. nueva → cabeza
            cabeza.anterior  = nueva;   // 4. cabeza ← nueva
            cola             = nueva;   // nueva ES la nueva cola
        }
        cantidad++;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 2 — NAVEGAR SIN LÍMITES (↑↓ infinito)
    //  La gran diferencia con lista doble simple:
    //  NO se verifica null — siempre hay nodo siguiente/anterior
    // ══════════════════════════════════════════════════════
    public void irSiguiente() {
        if (actual == null) { System.out.println("Lista vacía"); return; }
        actual = actual.siguiente;   // el último va al primero automáticamente
        System.out.println("Ahora en: " + actual.nombre);
    }

    public void irAnterior() {
        if (actual == null) { System.out.println("Lista vacía"); return; }
        actual = actual.anterior;    // el primero va al último automáticamente
        System.out.println("Ahora en: " + actual.nombre);
    }

    // ── COMPARACIÓN CLAVE PARA EL PARCIAL ─────────────────
    //  Lista doble SIMPLE:    if (actual.siguiente == null) → para
    //  Lista circular DOBLE:  no hay if → siempre da la vuelta


    // ══════════════════════════════════════════════════════
    //  PATRÓN 3 — RUTA MÁS CORTA EN ANILLO (metro)
    //  Solo posible en circular doble: compara ir adelante vs ir atrás
    // ══════════════════════════════════════════════════════
    public void rutaMasCorta(String nombreOrigen, String nombreDestino) {
        // Buscar los nodos origen y destino
        NodoCircularDoble origen  = buscar(nombreOrigen);
        NodoCircularDoble destino = buscar(nombreDestino);

        if (origen == null || destino == null) {
            System.out.println("Estación no encontrada"); return;
        }

        // Contar pasos hacia adelante (usando siguiente)
        NodoCircularDoble temp = origen.siguiente;
        int pasosAdelante = 1;
        while (temp != destino) {
            temp = temp.siguiente;
            pasosAdelante++;
        }

        // Contar pasos hacia atrás (usando anterior)
        temp = origen.anterior;
        int pasosAtras = 1;
        while (temp != destino) {
            temp = temp.anterior;
            pasosAtras++;
        }

        // Elegir la ruta más corta
        if (pasosAdelante <= pasosAtras) {
            System.out.println("Ir adelante: " + pasosAdelante + " paradas");
        } else {
            System.out.println("Ir atrás: " + pasosAtras + " paradas");
        }
    }

    private NodoCircularDoble buscar(String nombre) {
        if (cabeza == null) return null;
        NodoCircularDoble temp = cabeza;
        do {
            if (temp.nombre.equals(nombre)) return temp;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return null;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 4 — TOGGLE (activar/desactivar)
    //  Usado en: editor (visible/oculto), galería (favorita/no favorita)
    // ══════════════════════════════════════════════════════
    public void toggleActivo() {
        if (actual == null) return;
        actual.activo = !actual.activo;   // invierte el estado booleano
        System.out.println(actual.nombre + " → " + (actual.activo ? "activo" : "inactivo"));
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 5 — ELIMINAR NODO ACTUAL
    //  Diferencia con circular simple: ya tienes .anterior sin buscar
    //  Siempre re-cerrar el círculo con los 4 punteros
    // ══════════════════════════════════════════════════════
    public void eliminarActual() {
        if (cabeza == null) { System.out.println("Lista vacía"); return; }

        NodoCircularDoble aEliminar = actual;

        // Caso 1: único nodo
        if (actual.siguiente == actual) {
            cabeza = null; cola = null; actual = null; cantidad--; return;
        }

        // Mover cursor antes de eliminar
        actual = aEliminar.siguiente;    // cursor pasa al siguiente

        // Reconectar vecinos (sin dejar null — es circular)
        aEliminar.anterior.siguiente = aEliminar.siguiente;
        aEliminar.siguiente.anterior = aEliminar.anterior;

        // Actualizar cabeza/cola si hace falta
        if (aEliminar == cabeza) cabeza = aEliminar.siguiente;
        if (aEliminar == cola)   cola   = aEliminar.anterior;

        cantidad--;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 6 — RECORRER CON do-while
    //  Igual que en circular simple, pero puedes ir en ambas direcciones
    // ══════════════════════════════════════════════════════
    public void mostrarHaciaAdelante() {
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        NodoCircularDoble temp = cabeza;
        do {
            System.out.println(temp.nombre);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }

    public void mostrarHaciaAtras() {
        if (cola == null) { System.out.println("Lista vacía"); return; }
        NodoCircularDoble temp = cola;
        do {
            System.out.println(temp.nombre);
            temp = temp.anterior;
        } while (temp != cola);
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 7 — FILTRAR ACTIVOS (solo los visibles/favoritos)
    // ══════════════════════════════════════════════════════
    public void mostrarSoloActivos() {
        if (cabeza == null) return;
        NodoCircularDoble temp = cabeza;
        do {
            if (temp.activo) System.out.println("★ " + temp.nombre);
            else             System.out.println("  " + temp.nombre + " (oculto)");
            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
