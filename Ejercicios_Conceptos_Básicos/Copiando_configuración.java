public class Copiando_configuración {
    public static void main(String[] args) {

        int[] configuracion = {1920, 1080, 60};

        //se crea un nuevo arreglo y se copian los valores uno por uno
        int[] copia_Configuracion = new int[configuracion.length];
        for (int i = 0; i < configuracion.length; i++) {
            copia_Configuracion[i] = configuracion[i];
        }

        copia_Configuracion[2] = 30;

        System.out.println("Configuracion original - FPS: " + configuracion[2]);
        System.out.println("Copia configuracion - FPS: " + copia_Configuracion[2]);
    }
}
