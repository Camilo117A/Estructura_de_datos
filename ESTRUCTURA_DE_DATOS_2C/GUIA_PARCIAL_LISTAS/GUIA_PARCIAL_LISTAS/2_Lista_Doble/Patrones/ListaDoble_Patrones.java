// ============================================================
//  LISTA DOBLE — TODOS LOS PATRONES
//  La clave: siempre actualizar AMBOS punteros al modificar
// ============================================================

public class ListaDoble {

    NodoDoble cabeza;    // primer nodo
    NodoDoble cola;      // último nodo
    NodoDoble actual;    // cursor de navegación (para galería, reproductor, etc.)

    public ListaDoble() {
        this.cabeza  = null;
        this.cola    = null;
        this.actual  = null;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 1 — AGREGAR AL FINAL
    //  Usado en: galería, reproductor, pestañas, consultorio
    //  Diferencia con simple: hay que actualizar .anterior del nuevo
    // ══════════════════════════════════════════════════════
    public void agregarAlFinal(NodoDoble nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola   = nuevo;
            actual = nuevo;   // el cursor empieza en el primero
        } else {
            nuevo.anterior = cola;    // nuevo mira hacia atrás a la vieja cola
            cola.siguiente = nuevo;   // vieja cola mira hacia adelante al nuevo
            cola           = nuevo;   // el nuevo ES la nueva cola
        }
        // nuevo.siguiente ya es null (del constructor) — no hace falta setearlo
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 2 — AGREGAR AL INICIO
    //  Igual que simple pero actualizando .anterior de la vieja cabeza
    // ══════════════════════════════════════════════════════
    public void agregarAlInicio(NodoDoble nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola   = nuevo;
        } else {
            nuevo.siguiente  = cabeza;   // nuevo → vieja cabeza
            cabeza.anterior  = nuevo;    // vieja cabeza ← nuevo
            cabeza           = nuevo;    // nuevo ES la nueva cabeza
        }
        // nuevo.anterior ya es null — correcto para la cabeza
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 3 — NAVEGAR (siguiente y anterior)
    //  Usado en: galería, reproductor, undo/redo
    //  En lista doble SIMPLE hay que verificar null (hay límites)
    // ══════════════════════════════════════════════════════
    public void irSiguiente() {
        if (actual == null) {
            System.out.println("Lista vacía"); return;
        }
        if (actual.siguiente == null) {             // ← límite: fin de la lista
            System.out.println("Ya estás en el último"); return;
        }
        actual = actual.siguiente;
        System.out.println("Ahora en: " + actual.nombre);
    }

    public void irAnterior() {
        if (actual == null) {
            System.out.println("Lista vacía"); return;
        }
        if (actual.anterior == null) {              // ← límite: inicio de la lista
            System.out.println("Ya estás en el primero"); return;
        }
        actual = actual.anterior;
        System.out.println("Ahora en: " + actual.nombre);
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 4 — UNDO / REDO (cursor moviéndose)
    //  Usado en: ejercicio 1 (Control de Versiones)
    //  El cursor 'actual' sube y baja por la historia
    // ══════════════════════════════════════════════════════
    public NodoDoble deshacer(NodoDoble cambioActual) {
        if (cambioActual.anterior == null) {
            System.out.println("No hay más para deshacer");
            return cambioActual;           // se queda donde está
        }
        return cambioActual.anterior;      // mueve el cursor hacia atrás
    }

    public NodoDoble rehacer(NodoDoble cambioActual) {
        if (cambioActual.siguiente == null) {
            System.out.println("No hay más para rehacer");
            return cambioActual;           // se queda donde está
        }
        return cambioActual.siguiente;     // mueve el cursor hacia adelante
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 5 — ELIMINAR UN NODO (el más importante)
    //  Usado en: pestañas (cerrar), undo/redo avanzado
    //  4 casos que siempre hay que manejar
    // ══════════════════════════════════════════════════════
    public void eliminar(NodoDoble nodo) {

        // Caso 1: es el único nodo
        if (nodo.siguiente == null && nodo.anterior == null) {
            cabeza  = null;
            cola    = null;
            actual  = null;
            return;
        }

        // Caso 2: es la cabeza
        if (nodo == cabeza) {
            cabeza          = cabeza.siguiente;
            cabeza.anterior = null;          // nueva cabeza ya no tiene anterior
            if (actual == nodo) actual = cabeza;
            return;
        }

        // Caso 3: es la cola
        if (nodo == cola) {
            cola            = cola.anterior;
            cola.siguiente  = null;          // nueva cola ya no tiene siguiente
            if (actual == nodo) actual = cola;
            return;
        }

        // Caso 4: está en el medio
        nodo.anterior.siguiente = nodo.siguiente;  // el de atrás salta al siguiente
        nodo.siguiente.anterior = nodo.anterior;   // el de adelante salta al anterior
        if (actual == nodo) actual = nodo.siguiente;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 6 — RECORRER HACIA ATRÁS (desde la cola)
    //  Usado en: consultorio (buscar mayor edad desde la cola)
    //  Solo posible en lista doble
    // ══════════════════════════════════════════════════════
    public void mostrarAlReves() {
        NodoDoble temp = cola;               // empieza desde el final
        while (temp != null) {
            System.out.println(temp.nombre);
            temp = temp.anterior;            // va hacia atrás
        }
    }

    public NodoDoble buscarMaximoDesdeAtras() {
        if (cola == null) return null;
        NodoDoble temp  = cola;
        NodoDoble mayor = cola;
        while (temp != null) {
            if (temp.cantidad > mayor.cantidad) mayor = temp;
            temp = temp.anterior;
        }
        return mayor;
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 7 — INSERTAR EN SEGUNDA POSICIÓN (urgencia máxima)
    //  Usado en: consultorio (nivel_urgencia == 5)
    // ══════════════════════════════════════════════════════
    public void insertarSegundoPuesto(NodoDoble nuevo) {
        if (cabeza == null || cabeza.siguiente == null) {
            agregarAlFinal(nuevo);           // si hay 0 o 1 nodo, va al final
            return;
        }
        // Insertamos entre cabeza y cabeza.siguiente
        nuevo.siguiente             = cabeza.siguiente;  // nuevo → segundo viejo
        nuevo.anterior              = cabeza;            // nuevo ← cabeza
        cabeza.siguiente.anterior   = nuevo;             // segundo viejo ← nuevo
        cabeza.siguiente            = nuevo;             // cabeza → nuevo
    }


    // ══════════════════════════════════════════════════════
    //  PATRÓN 8 — RECORRER Y MOSTRAR (hacia adelante)
    // ══════════════════════════════════════════════════════
    public void mostrar() {
        NodoDoble temp = cabeza;
        int numero = 1;
        while (temp != null) {
            System.out.println(numero + ". " + temp.nombre);
            numero++;
            temp = temp.siguiente;
        }
    }
}
