public class ArbolBST {
    private Jugador raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    public void insertar(int elo, String nombreUsuario, String pais, int partidas) {
        raiz = insertarRec(raiz, elo, nombreUsuario, pais, partidas);
    }

    private Jugador insertarRec(Jugador nodo, int elo, String nombreUsuario, String pais, int partidas) {
        if (nodo == null) {
            return new Jugador(elo, nombreUsuario, pais, partidas);
        }
        if (elo < nodo.elo) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, elo, nombreUsuario, pais, partidas);
        } else if (elo > nodo.elo) {
            nodo.derecho = insertarRec(nodo.derecho, elo, nombreUsuario, pais, partidas);
        }
        return nodo;
    }

    public void listarEnRango(int eloMin, int eloMax) {
        listarEnRangoRec(raiz, eloMin, eloMax);
    }

    private void listarEnRangoRec(Jugador nodo, int eloMin, int eloMax) {
        if (nodo == null) {
            return;
        }
        if (nodo.elo > eloMin) {
            listarEnRangoRec(nodo.izquierdo, eloMin, eloMax);
        }
        if (nodo.elo >= eloMin && nodo.elo <= eloMax) {
            System.out.printf("  ELO: %-6d | Usuario: %-20s | Pais: %-15s | Partidas: %d%n",
                    nodo.elo, nodo.nombreUsuario, nodo.pais, nodo.partidasJugadas);
        }
        if (nodo.elo < eloMax) {
            listarEnRangoRec(nodo.derecho, eloMin, eloMax);
        }
    }

    public void recorrerInOrden() {
        recorrerInOrdenRec(raiz);
    }

    private void recorrerInOrdenRec(Jugador nodo) {
        if (nodo == null) {
            return;
        }
        recorrerInOrdenRec(nodo.izquierdo);
        System.out.printf("  ELO: %-6d | Usuario: %-20s | Pais: %-15s | Partidas: %d%n",
                nodo.elo, nodo.nombreUsuario, nodo.pais, nodo.partidasJugadas);
        recorrerInOrdenRec(nodo.derecho);
    }
}
