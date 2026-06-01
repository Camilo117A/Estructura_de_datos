public class ArbolTemperaturas {

    private Registro raiz;

    public ArbolTemperaturas() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    // --- INSERTAR ---

    private Registro insertar(Registro nodo, double temperatura, String fecha, String estacion, double humedad) {
        if (nodo == null)
            return new Registro(temperatura, fecha, estacion, humedad);

        if (temperatura < nodo.temperatura)
            nodo.izquierdo = insertar(nodo.izquierdo, temperatura, fecha, estacion, humedad);
        else if (temperatura > nodo.temperatura)
            nodo.derecho = insertar(nodo.derecho, temperatura, fecha, estacion, humedad);
        else
            System.out.println("Ya existe un registro con temperatura " + temperatura + "°C — no se insertó.");

        return nodo;
    }

    public void insertar(double temperatura, String fecha, String estacion, double humedad) {
        raiz = insertar(raiz, temperatura, fecha, estacion, humedad);
    }

    // --- BUSCAR ---

    private Registro buscar(Registro nodo, double temperatura) {
        if (nodo == null) return null;
        if (temperatura == nodo.temperatura) return nodo;

        if (temperatura < nodo.temperatura)
            return buscar(nodo.izquierdo, temperatura);
        else
            return buscar(nodo.derecho, temperatura);
    }

    public Registro buscar(double temperatura) {
        return buscar(raiz, temperatura);
    }

    // --- RECORRIDOS ---

    private void inOrden(Registro nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("  " + nodo);
            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  InOrden (temperatura ascendente):");
        inOrden(raiz);
    }

    private void preOrden(Registro nodo) {
        if (nodo != null) {
            System.out.println("  " + nodo);
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void preOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  PreOrden (raíz primero):");
        preOrden(raiz);
    }

    // --- ALTURA Y HOJAS ---

    private int altura(Registro nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Registro nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    // --- RETO: contarSobre(umbral) ---
    // Cuenta registros cuya temperatura sea estrictamente mayor al umbral.
    // Aprovecha la propiedad del BST: si nodo.temperatura <= umbral,
    // el subárbol izquierdo entero también estará por debajo — se poda.

    private int contarSobre(Registro nodo, double umbral) {
        if (nodo == null) return 0;

        if (nodo.temperatura <= umbral) {
            // Este nodo y todo su subárbol izquierdo quedan descartados.
            // Solo puede haber candidatos a la derecha.
            return contarSobre(nodo.derecho, umbral);
        } else {
            // Este nodo supera el umbral; el subárbol derecho también lo supera.
            // Aún hay que revisar el izquierdo porque puede tener valores > umbral.
            return 1 + contarSobre(nodo.derecho, umbral) + contarSobre(nodo.izquierdo, umbral);
        }
    }

    public int contarSobre(double umbral) {
        return contarSobre(raiz, umbral);
    }
}