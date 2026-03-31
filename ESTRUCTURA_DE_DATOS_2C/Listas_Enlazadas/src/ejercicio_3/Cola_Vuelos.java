public class Cola_Vuelos {
    Vuelos Cabeza;
    Vuelos Cola;

    public Cola_Vuelos() {
        this.Cabeza = null;
        this.Cola = null;
    }

    public void agregarVuelo(String Numero_vuelo, String Aerolinea, int Combustible_restante, int Pasajeros) {
        Vuelos Nuevo_vuelo = new Vuelos(Numero_vuelo, Aerolinea, Combustible_restante, Pasajeros);
        if (Cabeza == null) {
            Cabeza = Cola = Nuevo_vuelo;
        } else {
            Cola.Siguiente = Nuevo_vuelo;
            Cola = Nuevo_vuelo;
        }
        System.out.println("Vuelo " + Numero_vuelo + " agregado a la cola.");
    }

    public void reportarEmergencia(String Numero_vuelo) {
        if (Cabeza == null) return;

        if (Cabeza.Numero_vuelo.equals(Numero_vuelo)) {
            System.out.println("🚨 Vuelo " + Numero_vuelo + " ya está de primero en la cola.");
            return;
        }

        Vuelos Anterior = Cabeza;
        Vuelos Actual = Cabeza.Siguiente;

        while (Actual != null) {
            if (Actual.Numero_vuelo.equals(Numero_vuelo)) {
                Anterior.Siguiente = Actual.Siguiente;
                if (Actual == Cola) {
                    Cola = Anterior;
                }
                Actual.Siguiente = Cabeza;
                Cabeza = Actual;
                System.out.println("🚨 EMERGENCIA: Vuelo " + Numero_vuelo + " movido al inicio de la cola.");
                return;
            }
            Anterior = Actual;
            Actual = Actual.Siguiente;
        }
        System.out.println("Vuelo " + Numero_vuelo + " no encontrado en la cola.");
    }

    public void mostrarCola() {
        Vuelos Actual = Cabeza;
        while (Actual != null) {
            System.out.print("[" + Actual.Numero_vuelo + " | " + Actual.Aerolinea + " | Combustible: " + Actual.Combustible_restante + " | Pasajeros: " + Actual.Pasajeros + "]");
            if (Actual.Siguiente != null) System.out.print(" -> ");
            Actual = Actual.Siguiente;
        }
        System.out.println(" -> null");
    }

    public static void main(String[] args) {
        Cola_Vuelos Torre = new Cola_Vuelos();
        Torre.agregarVuelo("AV101", "Avianca", 45, 180);
        Torre.agregarVuelo("LA205", "LATAM", 8, 200);
        Torre.agregarVuelo("VV310", "Viva Air", 60, 150);
        System.out.println("\nCola antes de la emergencia:");
        Torre.mostrarCola();
        Torre.reportarEmergencia("LA205");
        System.out.println("\nCola después de la emergencia:");
        Torre.mostrarCola();
    }
}
