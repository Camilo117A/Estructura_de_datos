public class Vuelos {
    String Numero_vuelo;
    String Aerolinea;
    int Combustible_restante;
    int Pasajeros;
    Vuelos Siguiente;

    public Vuelos(String Numero_vuelo, String Aerolinea, int Combustible_restante, int Pasajeros) {
        this.Numero_vuelo = Numero_vuelo;
        this.Aerolinea = Aerolinea;
        this.Combustible_restante = Combustible_restante;
        this.Pasajeros = Pasajeros;
        this.Siguiente = null;
    }
}
