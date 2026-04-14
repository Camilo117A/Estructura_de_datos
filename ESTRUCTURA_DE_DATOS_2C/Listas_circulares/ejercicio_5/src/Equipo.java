public class Equipo {

    String nombre;
    String ciudad;
    int puntos;
    int goles_favor;
    Equipo siguiente;

    public Equipo(String nombre, String ciudad, int puntos, int goles_favor) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.puntos = puntos;
        this.goles_favor = goles_favor;
        this.siguiente = null;
    }
}