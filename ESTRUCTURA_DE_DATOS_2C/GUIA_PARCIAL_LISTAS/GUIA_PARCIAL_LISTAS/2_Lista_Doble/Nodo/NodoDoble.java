// ============================================================
//  LISTA DOBLE — EL NODO
//  Igual que el simple pero con DOS punteros: siguiente y anterior
// ============================================================

public class NodoDoble {

    // ── TUS DATOS (cambia según el ejercicio) ──────────────
    String nombre;
    int    cantidad;
    String descripcion;

    // ── LOS PUNTEROS — SIEMPRE ESTOS DOS ───────────────────
    NodoDoble siguiente;   // apunta hacia adelante
    NodoDoble anterior;    // apunta hacia atrás  ← esto es lo nuevo

    // ── CONSTRUCTOR ────────────────────────────────────────
    public NodoDoble(String nombre, int cantidad, String descripcion) {
        this.nombre      = nombre;
        this.cantidad    = cantidad;
        this.descripcion = descripcion;
        this.siguiente   = null;   // ambos null al crear
        this.anterior    = null;
    }
}

// ============================================================
//  EJEMPLOS REALES DE TUS EJERCICIOS
// ============================================================
//
//  Ejercicio 1 — Undo/Redo:
//      class Cambio { String texto; String tipoOperacion;
//                     Cambio siguiente; Cambio anterior; }
//
//  Ejercicio 2 — Galería:
//      class Fotografia { String nombre_archivo; double tamano_mb;
//                         String resolucion; Fotografia siguiente; Fotografia anterior; }
//
//  Ejercicio 3 — Pestañas:
//      class Pestana { String titulo_pagina; String url; String hora_apertura;
//                      Pestana siguiente; Pestana anterior; }
//
//  Ejercicio 4 — Consultorio:
//      class Paciente { String nombre; int edad; int nivel_urgencia;
//                       Paciente siguiente; Paciente anterior; }
//
//  Ejercicio 5 — Reproductor:
//      class Cancion { String titulo; String artista; int duracion;
//                      Cancion siguiente; Cancion anterior; }
// ============================================================
