public class Proceso {

    String nombre;
    int pid;
    int tiempo_restante;
    int prioridad;
    Proceso siguiente;

    public Proceso(String nombre, int pid, int tiempo_restante, int prioridad) {
        this.nombre = nombre;
        this.pid = pid;
        this.tiempo_restante = tiempo_restante;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}