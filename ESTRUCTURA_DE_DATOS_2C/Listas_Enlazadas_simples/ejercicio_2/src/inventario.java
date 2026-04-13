public class inventario {
    producto Cabeza;

    public inventario() {
        this.Cabeza = null;
    }

    public void agregarProducto(producto Nuevo_producto) {
        if (Nuevo_producto.Dias_para_vencer < 3) {
            Nuevo_producto.Siguiente = Cabeza;
            Cabeza = Nuevo_producto;
            System.out.println(Nuevo_producto.Nombre + " vence pronto, puesto al inicio.");
        } else {
            if (Cabeza == null) {
                Cabeza = Nuevo_producto;
            } else {
                producto Actual = Cabeza;
                while (Actual.Siguiente != null) {
                    Actual = Actual.Siguiente;
                }
                Actual.Siguiente = Nuevo_producto;
            }
        }
    }

    public void mostrarProximos_a_vencer() {
        System.out.println("\nProductos con menos de 5 dias para vencer:");
        producto Actual = Cabeza;
        while (Actual != null) {
            if (Actual.Dias_para_vencer < 5) {
                System.out.println("- " + Actual.Nombre + " | Cantidad: " + Actual.Cantidad + " | Dias: " + Actual.Dias_para_vencer);
            }
            Actual = Actual.Siguiente;
        }
    }

    public void mostrarEstante() {
        producto Actual = Cabeza;
        while (Actual != null) {
            System.out.print("[" + Actual.Nombre + " | " + Actual.Cantidad + " und | Vence en: " + Actual.Dias_para_vencer + " dias]");
            if (Actual.Siguiente != null) System.out.print(" -> ");
            Actual = Actual.Siguiente;
        }
        System.out.println(" -> null");
    }
}
