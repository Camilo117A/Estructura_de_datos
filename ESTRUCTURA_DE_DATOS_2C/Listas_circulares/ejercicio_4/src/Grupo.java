public class Grupo {

    String nombre_reserva;
    int numero_personas;
    boolean es_vip;
    int minutos_esperando;
    Grupo siguiente;

    public Grupo(String nombre_reserva, int numero_personas, boolean es_vip, int minutos_esperando) {
        this.nombre_reserva = nombre_reserva;
        this.numero_personas = numero_personas;
        this.es_vip = es_vip;
        this.minutos_esperando = minutos_esperando;
        this.siguiente = null;
    }
}