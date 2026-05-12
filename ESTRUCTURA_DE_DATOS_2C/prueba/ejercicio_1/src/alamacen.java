public class alamacen {
    //registrar un producto: agregar al final con codigo, nombre, cantidad y precio

    producto cabeza;
    public void agregarProducto(String codigo, String Nombre, int Cantidad, float precio) {
        producto nuevo = new producto(codigo, Nombre, Cantidad, precio);
        if (cabeza == null) {
            cabeza = nuevo;  // si la lista está vacía, el nuevo producto es la cabeza
        } else {
            producto actual = cabeza;
            while (actual.Siguiente != null) {
                actual = actual.Siguiente;  // avanza hasta el último producto
            }
            actual.Siguiente = nuevo;  // agrega el nuevo producto al final
        }
    }
    //buscar y editar: buscar por codigo y permitir actualizar la cantidad (sumar o restar el stock)


    //valor del intervalo: mostrar la lista completa y el valor total (suma de cantidad * precio de todos)
    public void mostrarInventario() {
        producto actual = cabeza;
        while (actual != null) {
            System.out.println("Código: " + actual.codigo + ", Nombre: " + actual.Nombre + ", Cantidad: " + actual.Cantidad + ", Precio: " + actual.precio);
            actual = actual.Siguiente;  // avanza al siguiente producto
            int total  = 0;
            while (actual != null) {
            total  += actual.precio;       // suma el campo que necesites
            actual  = actual.Siguiente;
        }
            System.out.print("valor total del producto es: " + total);
        }
    }
    //eliminar producto: buscar por codigo y eliminarlo de la lista
    public void eliminarProducto(String codigo) {
        if (cabeza == null) return;  // lista vacía, nada que eliminar

        if (cabeza.codigo.equals(codigo)) {
            cabeza = cabeza.Siguiente;  // elimina la cabeza
            return;
        }

        producto actual = cabeza;
        while (actual.Siguiente != null) {
            if (actual.Siguiente.codigo.equals(codigo)) {
                actual.Siguiente = actual.Siguiente.Siguiente;  // salta el producto a eliminar
                return;
            }
            actual = actual.Siguiente;  // avanza al siguiente producto
        }
    }
    //eliminar producto: pedir el codigo de un producto y eliminarlo de la lista (manejar correctamente si es la cabeza, el medio o el final)
    
}
