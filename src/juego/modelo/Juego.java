package juego.modelo;

import juego.modelo.contenido.Contenido;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class Juego {
    private Jugador jugadorFichaNegra;
    private Jugador jugadorFichaBlanca;
    private Tablero tableroReversi;

    public Juego(Jugador jugadorUno, Jugador jugadorDos) {
        this.jugadorFichaNegra = jugadorUno;
        this.jugadorFichaBlanca = jugadorDos;
        this.tableroReversi = new Tablero();
    }

    public Contenido getContenido(Posicion posicion) {
        return tableroReversi.getContenido(posicion);
    }
}
