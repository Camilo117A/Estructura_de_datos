public class Placa_de_un_vehículo {
    public static void main(String[] args) {
        // Información del vehículo
        String placa = "KLR-456";
        int año_Fabricacion = 2022;
        int cilindraje_CC = 1600;
        double precioCompra = 45000000.0;
        char inicialColor = 'R';
        boolean tieneSoatVigente = true;

        // Mostrar información organizada
        System.out.println("=== Registro Vehicular RUNT ===");
        System.out.println("Placa: " + placa);
        System.out.println("Año: " + año_Fabricacion);
        System.out.println("Cilindraje: " + cilindraje_CC + " cc");
        System.out.println("Precio de mercado: $" + precioCompra);
        System.out.println("Inicial Color: " + inicialColor);
        System.out.println("SOAT al día: " + tieneSoatVigente);
    }
}
