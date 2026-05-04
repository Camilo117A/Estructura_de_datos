// ============================================================
//  LISTA CIRCULAR — EL NODO
//  Idéntico al nodo simple — la diferencia está en la LISTA
//  El puntero 'siguiente' NUNCA será null (siempre apunta a algo)
// ============================================================

public class NodoCircular {

    // ── TUS DATOS ──────────────────────────────────────────
    String nombre;
    int    cantidad;
    String descripcion;

    // ── EL PUNTERO — igual que lista simple ─────────────────
    NodoCircular siguiente;   // en circular: el último apunta al primero

    public NodoCircular(String nombre, int cantidad, String descripcion) {
        this.nombre      = nombre;
        this.cantidad    = cantidad;
        this.descripcion = descripcion;
        this.siguiente   = null;   // null solo hasta que se agrega a la lista
    }
}

// ============================================================
//  EJEMPLOS REALES DE TUS EJERCICIOS
// ============================================================
//
//  Ejercicio 1 — Participante (sorteo):
//      class Participante { String nombre; int numeroBoleta;
//                           String ciudad; Participante siguiente; }
//
//  Ejercicio 2 — Anuncio (carrusel):
//      class Anuncio { String titulo; int duracion_segundos;
//                      int veces_repetido; String categoria; Anuncio siguiente; }
//
//  Ejercicio 3 — Proceso (Round Robin):
//      class Proceso { String nombre; int pid;
//                      int tiempo_restante; int prioridad; Proceso siguiente; }
//
//  Ejercicio 4 — Grupo (restaurante):
//      class Grupo { String nombre_reserva; int numero_personas;
//                    boolean es_vip; int minutos_esperando; Grupo siguiente; }
//
//  Ejercicio 5 — Equipo (torneo):
//      class Equipo { String nombre; String ciudad;
//                     int puntos; int goles_favor; Equipo siguiente; }
// ============================================================
