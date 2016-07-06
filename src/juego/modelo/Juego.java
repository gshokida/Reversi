package juego.modelo;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Contenido;
import juego.modelo.contenido.Ficha;
import juego.modelo.exceptions.CasilleroOcupadoNoSePuedeAgregarFichaException;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class Juego {
    private Jugador jugadorFichaNegra;
    private Jugador jugadorFichaBlanca;
    private Tablero tableroReversi;
    private ControlDeTurnos controlDeTurnos;

    public Juego(Jugador jugadorUno, Jugador jugadorDos) {
        this.jugadorFichaNegra = jugadorUno;
        this.jugadorFichaBlanca = jugadorDos;
        this.controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);
        this.tableroReversi = new Tablero();
    }

    public Contenido getContenido(Posicion posicion) {
        return tableroReversi.getContenido(posicion);
    }

    public Jugador getJugadorActual() {
        return this.controlDeTurnos.getJugadorActual();
    }

    public void setFicha(Posicion posicion) throws CasilleroOcupadoNoSePuedeAgregarFichaException {
        if (this.tableroReversi.getContenido(posicion).ocupado()) {
            throw new CasilleroOcupadoNoSePuedeAgregarFichaException();
        } else {
            Ficha ficha = obtenerFicha(this.getJugadorActual());
            this.tableroReversi.setContenido(ficha, posicion);
            this.controlDeTurnos.pasarTurno();
        }
    }

    private Ficha obtenerFicha(Jugador jugador) {
        Ficha ficha;
        if (jugador.equals(this.jugadorFichaBlanca)) {
            ficha = new Ficha(ColorBlanco.getInstance());
        } else {
            ficha = new Ficha(ColorNegro.getInstance());
        }

        return ficha;
    }
}
