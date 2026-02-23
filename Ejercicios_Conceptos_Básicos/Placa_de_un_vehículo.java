package Ejercicios_basicos;

public class RegistroVehiculo {
    public static void main(String[] args) {
        // Información del vehículo
        String placa = "KLR-456";
        int anioFabricacion = 2022;
        int cilindrajeCC = 1600;
        double precioCompra = 45000000.0;
        char inicialColor = 'R'; // R representa Rojo
        boolean tieneSoatVigente = true;

        // Mostrar información organizada
        System.out.println("=== Registro Vehicular RUNT ===");
        System.out.println("Placa: " + placa);
        System.out.println("Año: " + anioFabricacion);
        System.out.println("Cilindraje: " + cilindrajeCC + " cc");
        System.out.println("Precio de mercado: $" + precioCompra);
        System.out.println("Inicial Color: " + inicialColor);
        System.out.println("SOAT al día: " + tieneSoatVigente);
    }
}
