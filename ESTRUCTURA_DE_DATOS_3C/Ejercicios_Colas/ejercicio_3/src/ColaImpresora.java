public class ColaImpresora {

    private Documento salida;
    private Documento entrada;

    public ColaImpresora() {
        salida = null;
        entrada = null;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public void enqueue(Documento nuevo) {
        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
    }

    public Documento dequeue() {
        if (isEmpty()) return null;
        Documento impreso = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        return impreso;
    }

    public int calcularPaginasTotales() {
        int total = 0;
        Documento aux = salida;
        while (aux != null) {
            total += aux.numeroPaginas;
            aux = aux.siguiente;
        }
        return total;
    }

    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("No hay documentos en cola.");
            return;
        }
        System.out.print("SALIDA -> ");
        Documento aux = salida;
        while (aux != null) {
            System.out.print("[" + aux.nombreArchivo + " | " + aux.usuario + " | " + aux.numeroPaginas + " pags]");
            if (aux.siguiente != null) System.out.print(" -> ");
            aux = aux.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }
}
