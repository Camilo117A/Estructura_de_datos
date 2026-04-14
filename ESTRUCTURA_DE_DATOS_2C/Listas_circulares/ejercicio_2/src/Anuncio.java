public class Anuncio {

    String titulo;
    int duracion_segundos;
    int veces_repetido;
    String categoria;
    Anuncio siguiente;

    public Anuncio(String titulo, int duracion_segundos, String categoria) {
        this.titulo = titulo;
        this.duracion_segundos = duracion_segundos;
        this.veces_repetido = 0;
        this.categoria = categoria;
        this.siguiente = null;
    }
}