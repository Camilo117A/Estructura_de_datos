public class Cancion {
    String Titulo;
    String Artista;
    int Duracion_segundos;
    String Genero;
    Cancion Siguiente;

    public Cancion(String Titulo, String Artista, int Duracion_segundos, String Genero) {
        this.Titulo = Titulo;
        this.Artista = Artista;
        this.Duracion_segundos = Duracion_segundos;
        this.Genero = Genero;
        this.Siguiente = null;
    }
}
