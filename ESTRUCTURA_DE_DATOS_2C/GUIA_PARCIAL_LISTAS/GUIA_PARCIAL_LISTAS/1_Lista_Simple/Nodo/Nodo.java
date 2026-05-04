// ============================================================
//  LISTA SIMPLE — EL NODO
//  Solo cambia: nombre de la clase, atributos y constructor
// ============================================================

public class Nodo {

    // ── TUS DATOS (cambia según el ejercicio) ──────────────
    String nombre;          // ej: nombre, titulo, codigo...
    int    cantidad;        // ej: edad, precio, duracion...
    String descripcion;     // ej: ciudad, categoria, url...

    // ── EL PUNTERO — SIEMPRE IGUAL ─────────────────────────
    Nodo siguiente;         // apunta al siguiente nodo (null al final)

    // ── CONSTRUCTOR ────────────────────────────────────────
    public Nodo(String nombre, int cantidad, String descripcion) {
        this.nombre      = nombre;
        this.cantidad    = cantidad;
        this.descripcion = descripcion;
        this.siguiente   = null;   // siempre null al crear
    }
}

// ============================================================
//  EJEMPLOS REALES DE TUS EJERCICIOS
// ============================================================
//
//  Ejercicio 1 — Tren:
//      class vagon { String contenido; double pesoToneladas;
//                    String origen; String destino; vagon siguiente; }
//
//  Ejercicio 2 — Inventario:
//      class producto { String Nombre; int Cantidad;
//                       int Dias_para_vencer; producto Siguiente; }
//
//  Ejercicio 3 — Vuelos:
//      class Vuelos { String Numero_vuelo; String Aerolinea;
//                     int Combustible_restante; int Pasajeros; Vuelos Siguiente; }
//
//  Ejercicio 4 — Sensores:
//      class Lectura { int Id_sensor; double Temperatura;
//                      double Presion; String Hora; Lectura Siguiente; }
//
//  Ejercicio 5 — Cancion:
//      class Cancion { String Titulo; String Artista;
//                      int Duracion_segundos; String Genero; Cancion Siguiente; }
// ============================================================
