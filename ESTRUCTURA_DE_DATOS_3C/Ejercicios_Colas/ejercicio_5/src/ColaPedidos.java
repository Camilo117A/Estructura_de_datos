public class ColaPedidos {

    private Pedido salida;
    private Pedido entrada;

    public ColaPedidos() {
        salida = null;
        entrada = null;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public void enqueue(Pedido nuevo) {
        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
    }

    public Pedido dequeue() {
        if (isEmpty()) return null;
        Pedido procesado = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        return procesado;
    }

    public void procesarPedidos() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
            return;
        }
        int totalDespachados = 0;
        int totalCancelados = 0;
        System.out.println("\n--- Procesando pedidos de bodega ---");
        while (!isEmpty()) {
            Pedido p = dequeue();
            if (p.cancelado) {
                totalCancelados++;
                System.out.println("CANCELADO: Pedido " + p.numeroPedido + " de " + p.cliente + " descartado.");
            } else {
                totalDespachados++;
                System.out.println("DESPACHADO: Pedido " + p.numeroPedido);
                System.out.println("  Cliente : " + p.cliente);
                System.out.println("  Total   : $" + String.format("%.2f", p.totalPagar));
            }
        }
        System.out.println("\nResumen de bodega:");
        System.out.println("  Pedidos despachados : " + totalDespachados);
        System.out.println("  Pedidos cancelados  : " + totalCancelados);
    }

    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en espera.");
            return;
        }
        System.out.print("SALIDA -> ");
        Pedido aux = salida;
        while (aux != null) {
            String estado = aux.cancelado ? "CANCELADO" : "vigente";
            System.out.print("[" + aux.numeroPedido + " | " + aux.cliente + " | " + estado + "]");
            if (aux.siguiente != null) System.out.print(" -> ");
            aux = aux.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }
}
