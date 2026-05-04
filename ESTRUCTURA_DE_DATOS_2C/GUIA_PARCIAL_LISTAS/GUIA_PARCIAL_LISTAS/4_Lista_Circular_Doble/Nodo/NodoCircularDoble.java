// ============================================================
//  LISTA CIRCULAR DOBLE — EL NODO
//  Tiene: siguiente + anterior, y NINGUNO será null jamás
//  Es la combinación de lista doble + lista circular
// ============================================================

public class NodoCircularDoble {

    // ── TUS DATOS ──────────────────────────────────────────
    String nombre;
    int    cantidad;
    String descripcion;
    boolean activo;         // algunos ejercicios usan toggles (visible, favorita)

    // ── DOS PUNTEROS — NUNCA SERÁN NULL ─────────────────────
    NodoCircularDoble siguiente;   // → avanza (y el último llega al primero)
    NodoCircularDoble anterior;    // ← retrocede (y el primero llega al último)

    public NodoCircularDoble(String nombre, int cantidad, String descripcion) {
        this.nombre      = nombre;
        this.cantidad    = cantidad;
        this.descripcion = descripcion;
        this.activo      = true;
        this.siguiente   = null;   // null solo hasta que se agrega a la lista
        this.anterior    = null;
    }
}

// ============================================================
//  EJEMPLOS REALES DE TUS EJERCICIOS
// ============================================================
//
//  Ejercicio 1 — Estacion (metro):
//      class Estacion { String nombre; int zona;
//                       Estacion siguiente; Estacion anterior; }
//
//  Ejercicio 2 — Comando (historial terminal):
//      class Comando { String texto; String hora;
//                      Comando siguiente; Comando anterior; }
//
//  Ejercicio 3 — Capa (editor):
//      class Capa { String nombre; String tipo; boolean visible;
//                   Capa siguiente; Capa anterior; }
//
//  Ejercicio 4 — Foto (galería circular):
//      class Foto { String nombre_archivo; String fecha;
//                   boolean esFavorita; Foto siguiente; Foto anterior; }
// ============================================================
