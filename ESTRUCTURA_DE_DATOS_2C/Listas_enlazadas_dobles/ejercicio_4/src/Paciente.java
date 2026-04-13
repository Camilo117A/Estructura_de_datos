public class Paciente {

    String nombre;
    int edad;
    int nivel_urgencia;
    Paciente siguiente;
    Paciente anterior;

    public Paciente(String nombre, int edad, int nivel_urgencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivel_urgencia = nivel_urgencia;
        this.siguiente = null;
        this.anterior = null;
    }
}