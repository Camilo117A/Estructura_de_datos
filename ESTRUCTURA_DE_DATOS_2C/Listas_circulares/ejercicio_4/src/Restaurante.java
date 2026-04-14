public class Restaurante {

    Grupo cabeza;
    Grupo cola;
    int cantidad;

    public Restaurante() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    public void agregar_grupo(String nombre_reserva, int numero_personas, boolean es_vip, int minutos_esperando) {
        Grupo nuevo = new Grupo(nombre_reserva, numero_personas, es_vip, minutos_esperando);

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
        System.out.println("Grupo registrado: " + nombre_reserva + " | VIP: " + (es_vip ? "Si" : "No"));
    }

    public void atender_siguiente() {
        if (cabeza == null) {
            System.out.println("No hay grupos en espera.");
            return;
        }

        Grupo atendido = cabeza;

        System.out.println("\n====== Atendiendo grupo ======");
        System.out.println("  Reserva  : " + atendido.nombre_reserva);
        System.out.println("  Personas : " + atendido.numero_personas);
        System.out.println("  VIP      : " + (atendido.es_vip ? "Si" : "No"));
        System.out.println("  Esperando: " + atendido.minutos_esperando + " min");

        if (atendido.es_vip) {
            System.out.println("  -> Grupo VIP, vuelve al final de la lista.");

            if (cantidad == 1) {
                System.out.println("  (Es el unico grupo, se queda en su lugar.)");
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = atendido;
                cola = atendido;
                cola.siguiente = cabeza;
            }

        } else {
            System.out.println("  -> Grupo atendido, sale de la lista.");

            if (cantidad == 1) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
            cantidad--;
        }

        mostrar_lista();
    }

    public void mostrar_lista() {
        if (cabeza == null) {
            System.out.println("La lista de espera esta vacia.");
            return;
        }
        Grupo temp = cabeza;
        System.out.println("====== Lista de espera actual ======");
        do {
            System.out.println("  " + temp.nombre_reserva
                    + " | Personas: " + temp.numero_personas
                    + " | VIP: " + (temp.es_vip ? "Si" : "No")
                    + " | Espera: " + temp.minutos_esperando + " min");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("====================================");
    }
}