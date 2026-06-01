public class ArbolBST {
    private Repuesto raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    public void insertar(int codigoRef, String descripcion, String marca, int stock) {
        raiz = insertarRec(raiz, codigoRef, descripcion, marca, stock);
    }

    private Repuesto insertarRec(Repuesto nodo, int codigoRef, String descripcion, String marca, int stock) {
        if (nodo == null) {
            return new Repuesto(codigoRef, descripcion, marca, stock);
        }
        if (codigoRef < nodo.codigoRef) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, codigoRef, descripcion, marca, stock);
        } else if (codigoRef > nodo.codigoRef) {
            nodo.derecho = insertarRec(nodo.derecho, codigoRef, descripcion, marca, stock);
        }
        return nodo;
    }

    public void backupPreOrden() {
        backupPreOrdenRec(raiz);
    }

    private void backupPreOrdenRec(Repuesto nodo) {
        if (nodo == null) {
            return;
        }
        System.out.printf("  [%04d] %-30s - %-15s (%d uds)%n",
                nodo.codigoRef, nodo.descripcion, nodo.marca, nodo.stock);
        backupPreOrdenRec(nodo.izquierdo);
        backupPreOrdenRec(nodo.derecho);
    }

    public void reporteRepuestosUnicos() {
        int hojas = contarHojas(raiz);
        System.out.println("\n--- REPORTE DE REPUESTOS UNICOS ---");
        System.out.println("  Repuestos sin variantes relacionadas (hojas): " + hojas);
        if (hojas == 1) {
            System.out.println("  Hay 1 repuesto que no tiene variantes en el catalogo.");
        } else {
            System.out.println("  Hay " + hojas + " repuestos que no tienen variantes en el catalogo.");
        }
    }

    private int contarHojas(Repuesto nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public void recorrerInOrden() {
        recorrerInOrdenRec(raiz);
    }

    private void recorrerInOrdenRec(Repuesto nodo) {
        if (nodo == null) {
            return;
        }
        recorrerInOrdenRec(nodo.izquierdo);
        System.out.printf("  [%04d] %-30s - %-15s (%d uds)%n",
                nodo.codigoRef, nodo.descripcion, nodo.marca, nodo.stock);
        recorrerInOrdenRec(nodo.derecho);
    }
}
