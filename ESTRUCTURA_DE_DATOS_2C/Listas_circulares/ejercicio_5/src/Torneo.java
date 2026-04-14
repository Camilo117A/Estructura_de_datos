public class Torneo {

    Equipo cabeza;
    Equipo cola;
    int cantidad;

    public Torneo() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    public void agregar_equipo(String nombre, String ciudad, int puntos, int goles_favor) {
        Equipo nuevo = new Equipo(nombre, ciudad, puntos, goles_favor);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
        cantidad++;
        System.out.println("Equipo registrado: " + nombre + " de " + ciudad);
    }

    public void generar_fixture() {
        if (cantidad < 2) {
            System.out.println("Se necesitan al menos 2 equipos para generar el fixture.");
            return;
        }

        int total_jornadas = cantidad - 1;

        System.out.println("\n====== Fixture del Torneo ======");

        for (int jornada = 1; jornada <= total_jornadas; jornada++) {

            System.out.println("\n-- Jornada " + jornada + " --");

            Equipo[] lista = new Equipo[cantidad];
            Equipo temp = cabeza;
            for (int i = 0; i < cantidad; i++) {
                lista[i] = temp;
                temp = temp.siguiente;
            }

            int mitad = cantidad / 2;
            for (int i = 0; i < mitad; i++) {
                System.out.println("  " + lista[i].nombre + " vs " + lista[cantidad - 1 - i].nombre);
            }

            rotar_lista();
        }

        mostrar_tabla();
    }

    private void rotar_lista() {
        if (cantidad <= 1) return;

        Equipo fijo = cabeza;
        Equipo segundo = cabeza.siguiente;

        Equipo penultimo = cabeza;
        for (int i = 0; i < cantidad - 2; i++) {
            penultimo = penultimo.siguiente;
        }

        Equipo ultimo = cola;

        fijo.siguiente = ultimo;
        ultimo.siguiente = segundo;
        penultimo.siguiente = fijo;
        cola = penultimo;
        cola.siguiente = cabeza;
    }

    public void mostrar_tabla() {
        if (cabeza == null) {
            System.out.println("No hay equipos registrados.");
            return;
        }

        Equipo[] lista = new Equipo[cantidad];
        Equipo temp = cabeza;
        for (int i = 0; i < cantidad; i++) {
            lista[i] = temp;
            temp = temp.siguiente;
        }

        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = i + 1; j < cantidad; j++) {
                if (lista[j].puntos > lista[i].puntos) {
                    Equipo aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }
        }

        System.out.println("\n====== Tabla de Posiciones ======");
        System.out.println("  Pos | Equipo              | Ciudad        | Puntos | Goles");
        System.out.println("  ----|---------------------|---------------|--------|------");
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("  %-4d| %-20s| %-14s| %-7d| %d%n",
                    (i + 1), lista[i].nombre, lista[i].ciudad, lista[i].puntos, lista[i].goles_favor);
        }
        System.out.println("=================================");
    }

    public void mostrar_equipos() {
        if (cabeza == null) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        Equipo temp = cabeza;
        System.out.println("====== Equipos registrados ======");
        do {
            System.out.println("  " + temp.nombre + " | " + temp.ciudad
                    + " | Puntos: " + temp.puntos
                    + " | Goles: " + temp.goles_favor);
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("=================================");
    }
}