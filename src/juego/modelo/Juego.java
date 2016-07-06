package juego.modelo;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Contenido;
import juego.modelo.contenido.Ficha;
import juego.modelo.exceptions.CasilleroOcupadoNoSePuedeAgregarFichaException;
import juego.modelo.exceptions.PosicionNoValidaNoSePuedeAgregarFichaException;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class Juego {
    private Jugador jugadorFichaNegra;
    private Jugador jugadorFichaBlanca;
    private Tablero tableroReversi;
    private ControlDeTurnos controlDeTurnos;
    private int tamanioTablero = 8;

    public Juego(Jugador jugadorUno, Jugador jugadorDos) {
        this.jugadorFichaNegra = jugadorUno;
        this.jugadorFichaBlanca = jugadorDos;
        this.controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);
        this.tableroReversi = new Tablero(tamanioTablero);
    }

    public Contenido getContenido(Posicion posicion) {
        return tableroReversi.getContenido(posicion);
    }

    public Jugador getJugadorActual() {
        return this.controlDeTurnos.getJugadorActual();
    }

    public void setFicha(Posicion posicion) throws CasilleroOcupadoNoSePuedeAgregarFichaException, PosicionNoValidaNoSePuedeAgregarFichaException {
        if (this.tableroReversi.getContenido(posicion).ocupado()) {
            throw new CasilleroOcupadoNoSePuedeAgregarFichaException();
        } else {

            Ficha ficha = obtenerFicha(this.getJugadorActual());

            if (this.tableroReversi.estaVacio()){
                this.tableroReversi.setContenido(ficha, posicion);
                this.controlDeTurnos.pasarTurno();
            } else {
                if (verificarPosicionValida(posicion)) {
                    this.tableroReversi.setContenido(ficha, posicion);
                    this.controlDeTurnos.pasarTurno();
                } else {
                    throw new PosicionNoValidaNoSePuedeAgregarFichaException();
                }
            }
        }
    }

    private boolean verificarPosicionValida(Posicion posicion) {
        Posicion posicionAlrededor = new Posicion(posicion.getFila(), posicion.getColumna());
        boolean posicionValida = false;

        if (this.tamanioTablero < posicion.getFila() + 1) {
            posicionAlrededor.setFila(posicionAlrededor.getFila() + 1);
        }


        return posicionValida;
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
