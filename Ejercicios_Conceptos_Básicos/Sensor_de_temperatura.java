public class Sensor_de_temperatura {
    public static void main(String[] args) {
        // Datos del sensor
        String nombre = "Sensor Industrial A-1";
        int numero_Lectura = 452;
        double temperatura_Celsius = 85.5;
        
        // Lógica de alarma: se activa si supera los 80°C
        boolean enAlarma = temperatura_Celsius > 80.0;

        // Reporte de estado
        System.out.println("Reporte de Sensor");
        System.out.println("ID Sensor: " + nombre);
        System.out.println("Lectura No: " + numero_Lectura);
        System.out.println("Temperatura: " + temperatura_Celsius + "°C");
        System.out.println("ESTADO DE ALARMA: " + enAlarma);
    }
}
