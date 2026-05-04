// ============================================================
//
//   GUÍA COMPLETA DE LISTAS — RESUMEN PARA EL PARCIAL
//   Estructura de Datos 2C
//
// ============================================================


// ════════════════════════════════════════════════════════════
//  1. ¿QUÉ LISTA USAR SEGÚN EL ENUNCIADO?
// ════════════════════════════════════════════════════════════

/*
  El enunciado dice...                    → Usas esta lista
  ──────────────────────────────────────────────────────────
  "agregar y mostrar en orden"            → Simple
  "insertar urgente al inicio"            → Simple
  "calcular total / buscar máximo"        → Simple
  "mover un nodo a otra posición"         → Simple

  "ir y volver entre elementos"           → Doble
  "deshacer / rehacer (undo/redo)"        → Doble
  "eliminar el elemento actual"           → Doble
  "mostrar desde el último al primero"    → Doble

  "turnos que se repiten"                 → Circular Simple
  "ruleta / sorteo avanzando N pasos"     → Circular Simple
  "ciclos infinitos sin null"             → Circular Simple
  "Round Robin / distribuir tiempo"       → Circular Simple

  "ir en ambos sentidos SIN límite"       → Circular Doble
  "ruta más corta en un anillo"           → Circular Doble
  "historial ↑↓ que da la vuelta"         → Circular Doble
  "activar/desactivar capas en ciclo"     → Circular Doble
*/


// ════════════════════════════════════════════════════════════
//  2. ESTRUCTURA DE CADA NODO — DE UN VISTAZO
// ════════════════════════════════════════════════════════════

/*
  LISTA SIMPLE:
      class Nodo {
          // tus datos
          Nodo siguiente;       // solo este puntero
      }

  LISTA DOBLE:
      class Nodo {
          // tus datos
          Nodo siguiente;
          Nodo anterior;        // agrega este
      }

  LISTA CIRCULAR SIMPLE:
      class Nodo {
          // tus datos
          Nodo siguiente;       // igual que simple, pero nunca será null
      }

  LISTA CIRCULAR DOBLE:
      class Nodo {
          // tus datos
          Nodo siguiente;       // nunca null
          Nodo anterior;        // nunca null
      }
*/


// ════════════════════════════════════════════════════════════
//  3. AGREGAR — PATRÓN SEGÚN LISTA
// ════════════════════════════════════════════════════════════

/*
  ── SIMPLE al final ──────────────────────────────────────────
      if (cabeza == null) { cabeza = nuevo; }
      else {
          Nodo actual = cabeza;
          while (actual.siguiente != null) actual = actual.siguiente;
          actual.siguiente = nuevo;
      }

  ── SIMPLE al inicio ─────────────────────────────────────────
      nuevo.siguiente = cabeza;
      cabeza = nuevo;

  ── SIMPLE en medio (después de nodoX) ───────────────────────
      nuevo.siguiente  = nodoX.siguiente;   // 1° primero enlaza nuevo
      nodoX.siguiente  = nuevo;             // 2° luego actualiza nodoX
      // ⚠ Si inviertes el orden, pierdes la cadena

  ── DOBLE al final ───────────────────────────────────────────
      if (cabeza == null) { cabeza = nueva; cola = nueva; }
      else {
          nueva.anterior = cola;
          cola.siguiente = nueva;
          cola = nueva;
      }

  ── CIRCULAR SIMPLE ──────────────────────────────────────────
      if (cabeza == null) {
          cabeza = nuevo; cola = nuevo;
          nuevo.siguiente = cabeza;        // apunta a sí mismo
      } else {
          cola.siguiente  = nuevo;
          nuevo.siguiente = cabeza;        // cierra el círculo
          cola            = nuevo;
      }

  ── CIRCULAR DOBLE (4 pasos, siempre este orden) ─────────────
      if (cabeza == null) {
          nueva.siguiente = nueva; nueva.anterior = nueva;
          cabeza = nueva; cola = nueva;
      } else {
          cola.siguiente  = nueva;    // 1
          nueva.anterior  = cola;     // 2
          nueva.siguiente = cabeza;   // 3
          cabeza.anterior = nueva;    // 4
          cola = nueva;
      }
*/


// ════════════════════════════════════════════════════════════
//  4. RECORRER — PATRÓN SEGÚN LISTA
// ════════════════════════════════════════════════════════════

/*
  ── SIMPLE y DOBLE (hacia adelante) ──────────────────────────
      Nodo actual = cabeza;
      while (actual != null) {
          // procesar actual
          actual = actual.siguiente;
      }

  ── DOBLE (hacia atrás desde la cola) ────────────────────────
      Nodo temp = cola;
      while (temp != null) {
          // procesar temp
          temp = temp.anterior;
      }

  ── CIRCULAR SIMPLE y CIRCULAR DOBLE ─────────────────────────
      Nodo temp = cabeza;
      do {
          // procesar temp
          temp = temp.siguiente;
      } while (temp != cabeza);
      // ⚠ Siempre do-while — nunca while para circulares
*/


// ════════════════════════════════════════════════════════════
//  5. ELIMINAR — LOS CASOS QUE SIEMPRE APARECEN
// ════════════════════════════════════════════════════════════

/*
  ── SIMPLE ───────────────────────────────────────────────────
      // Guardar anterior mientras buscas:
      Nodo anterior = null, actual = cabeza;
      while (actual != null && !actual.nombre.equals(buscado)) {
          anterior = actual;
          actual   = actual.siguiente;
      }
      if (actual == null) return;          // no encontrado
      if (anterior == null) cabeza = actual.siguiente; // era la cabeza
      else anterior.siguiente = actual.siguiente;      // medio o cola

  ── DOBLE — 4 casos ──────────────────────────────────────────
      if (nodo == cabeza && nodo == cola)  { cabeza = null; cola = null; }
      else if (nodo == cabeza)             { cabeza = cabeza.siguiente; cabeza.anterior = null; }
      else if (nodo == cola)               { cola = cola.anterior; cola.siguiente = null; }
      else {
          nodo.anterior.siguiente = nodo.siguiente;
          nodo.siguiente.anterior = nodo.anterior;
      }

  ── CIRCULAR SIMPLE ──────────────────────────────────────────
      if (cabeza == cola) { cabeza = null; cola = null; }      // único
      else if (nodo == cabeza) {
          cabeza = cabeza.siguiente;
          cola.siguiente = cabeza;    // ← re-cierra el círculo
      } else {
          // buscar anterior con while...
          anterior.siguiente = nodo.siguiente;
          if (nodo == cola) cola = anterior;
      }

  ── CIRCULAR DOBLE ───────────────────────────────────────────
      if (actual.siguiente == actual) { cabeza=null; cola=null; actual=null; }
      else {
          NodoCircularDoble e = actual;
          actual = e.siguiente;                  // cursor al siguiente
          e.anterior.siguiente = e.siguiente;    // re-enlaza sin poner null
          e.siguiente.anterior = e.anterior;
          if (e == cabeza) cabeza = e.siguiente;
          if (e == cola)   cola   = e.anterior;
      }
*/


// ════════════════════════════════════════════════════════════
//  6. ERRORES MÁS COMUNES EN EL PARCIAL
// ════════════════════════════════════════════════════════════

/*
  ✗  En circular usar while en lugar de do-while
  ✗  Olvidar cola.siguiente = cabeza al eliminar en circular
  ✗  Invertir el orden al insertar en medio (perder la cadena)
  ✗  En doble, no actualizar .anterior al eliminar la cabeza
  ✗  En circular doble, poner null en algún puntero (nunca hay null)
  ✗  Usar == para comparar Strings (usar .equals())
  ✗  No manejar el caso lista vacía (if cabeza == null al inicio)
  ✗  Olvidar actualizar cola al agregar el primer elemento

  ✓  Siempre revisa los 3 casos: vacía, un nodo, varios nodos
  ✓  En circular: siempre necesitas cabeza Y cola
  ✓  En doble: siempre actualizar AMBOS punteros al modificar
*/


// ════════════════════════════════════════════════════════════
//  7. PATRÓN PARA RESOLVER CUALQUIER EJERCICIO DEL PARCIAL
// ════════════════════════════════════════════════════════════

/*
  Paso 1: Lee el enunciado → identifica qué lista usar (ver sección 1)

  Paso 2: Crea el NODO
          → copia el patrón de nodo correspondiente
          → cambia el nombre de la clase y los atributos
          → mantén el/los puntero(s) igual

  Paso 3: Crea la LISTA
          → cabeza = null, cola = null (si aplica), actual = null (si aplica)

  Paso 4: Método AGREGAR
          → copia el patrón exacto de la sección 3
          → solo cambia el nombre de la clase del nodo

  Paso 5: Método ESPECÍFICO del ejercicio
          → busca el patrón más cercano en esta guía
          → adapta los nombres y la lógica del enunciado

  Paso 6: Método MOSTRAR
          → copia el patrón de recorrido de la sección 4

  Paso 7: Prueba mentalmente con 3 nodos y los casos borde:
          lista vacía, 1 solo nodo, varios nodos
*/
