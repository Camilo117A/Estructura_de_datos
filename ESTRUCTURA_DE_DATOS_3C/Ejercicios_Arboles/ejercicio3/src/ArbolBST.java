public class ArbolBST {
    private Empleado raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    public void insertar(long cedula, String nombreCompleto, String cargo, double salario) {
        raiz = insertarRec(raiz, cedula, nombreCompleto, cargo, salario);
    }

    private Empleado insertarRec(Empleado nodo, long cedula, String nombreCompleto, String cargo, double salario) {
        if (nodo == null) {
            return new Empleado(cedula, nombreCompleto, cargo, salario);
        }
        if (cedula < nodo.cedula) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, cedula, nombreCompleto, cargo, salario);
        } else if (cedula > nodo.cedula) {
            nodo.derecho = insertarRec(nodo.derecho, cedula, nombreCompleto, cargo, salario);
        }
        return nodo;
    }

    public void buscarMinimo() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        Empleado minimo = buscarMinimoRec(raiz);
        System.out.println("\n--- EMPLEADO CON CEDULA MINIMA ---");
        imprimirEmpleado(minimo);
    }

    private Empleado buscarMinimoRec(Empleado nodo) {
        if (nodo.izquierdo == null) {
            return nodo;
        }
        return buscarMinimoRec(nodo.izquierdo);
    }

    public void buscarMaximo() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        Empleado maximo = buscarMaximoRec(raiz);
        System.out.println("\n--- EMPLEADO CON CEDULA MAXIMA ---");
        imprimirEmpleado(maximo);
    }

    private Empleado buscarMaximoRec(Empleado nodo) {
        if (nodo.derecho == null) {
            return nodo;
        }
        return buscarMaximoRec(nodo.derecho);
    }

    public void reporteEficiencia() {
        int altura = calcularAltura(raiz);
        int hojas = contarHojas(raiz);
        System.out.println("\n--- REPORTE DE EFICIENCIA DEL ARBOL ---");
        System.out.println("  Altura actual del arbol : " + altura);
        System.out.println("  Total de nodos hoja     : " + hojas);
        System.out.println("  Busqueda eficiente hasta: " + altura + " comparaciones");
    }

    private int calcularAltura(Empleado nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = calcularAltura(nodo.izquierdo);
        int alturaDer = calcularAltura(nodo.derecho);
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    private int contarHojas(Empleado nodo) {
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

    private void recorrerInOrdenRec(Empleado nodo) {
        if (nodo == null) {
            return;
        }
        recorrerInOrdenRec(nodo.izquierdo);
        imprimirEmpleado(nodo);
        recorrerInOrdenRec(nodo.derecho);
    }

    private void imprimirEmpleado(Empleado e) {
        System.out.printf("  Cedula: %-12d | Nombre: %-25s | Cargo: %-20s | Salario: $%,.2f%n",
                e.cedula, e.nombreCompleto, e.cargo, e.salario);
    }
}
