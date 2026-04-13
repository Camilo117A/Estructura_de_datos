public class Pestana {

    String titulo_pagina;
    String url;
    String hora_apertura;
    Pestana siguiente;
    Pestana anterior;

    public Pestana(String titulo_pagina, String url, String hora_apertura) {
        this.titulo_pagina = titulo_pagina;
        this.url = url;
        this.hora_apertura = hora_apertura;
        this.siguiente = null;
        this.anterior = null;
    }
}