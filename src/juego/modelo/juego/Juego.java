package juego.modelo.juego;

import juego.modelo.contenido.*;
import juego.modelo.tablero.Posicion;
import juego.modelo.tablero.Tablero;
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

            voltearFichasPorFlanqueo(posicion);
        }
    }

    private void voltearFichasPorFlanqueo(Posicion posicion) {
        Posicion posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());
        Color color = this.tableroReversi.getContenido(posicion).getColor();
        boolean flanquea = false;
        int i = 1;
        int j = 1;

        posicionAlterna.setColumna(posicion.getColumna() + 1);
        while (posicionAlterna.getColumna() < this.tamanioTablero && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
            flanquea = flanquea || this.tableroReversi.getContenido(posicionAlterna).getColor() == color;
            i++;
            posicionAlterna.setColumna(posicion.getColumna() + i);
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());

        if (flanquea) {
            posicionAlterna.setColumna(posicion.getColumna() + 1);
            while (posicionAlterna.getColumna() < posicion.getColumna() + i && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
                this.tableroReversi.getContenido(posicionAlterna).setColor(color);
                j++;
                posicionAlterna.setColumna(posicion.getColumna() + j);
            }
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());

        flanquea = false;
        i = 1;
        j = 1;
        posicionAlterna.setColumna(posicion.getColumna() - 1);
        while (posicionAlterna.getColumna() > 0 && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
            flanquea = flanquea || this.tableroReversi.getContenido(posicionAlterna).getColor() == color;
            i++;
            posicionAlterna.setColumna(posicion.getColumna() - i);
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());

        if (flanquea) {
            posicionAlterna.setColumna(posicion.getColumna() - 1);
            while (posicionAlterna.getColumna() > posicion.getColumna() - i && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
                this.tableroReversi.getContenido(posicionAlterna).setColor(color);
                j++;
                posicionAlterna.setColumna(posicion.getColumna() - j);
            }
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());
        flanquea = false;
        i = 1;
        j = 1;

        posicionAlterna.setFila(posicion.getFila() + 1);
        while (posicionAlterna.getFila() < this.tamanioTablero && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
            flanquea = flanquea || this.tableroReversi.getContenido(posicionAlterna).getColor() == color;
            i++;
            posicionAlterna.setFila(posicion.getFila() + i);
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());

        if (flanquea) {
            posicionAlterna.setFila(posicion.getFila() + 1);
            while (posicionAlterna.getFila() < posicion.getFila() + i && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
                this.tableroReversi.getContenido(posicionAlterna).setColor(color);
                j++;
                posicionAlterna.setFila(posicion.getFila() + j);
            }
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());
        flanquea = false;
        i = 1;
        j = 1;

        posicionAlterna.setFila(posicion.getFila() - 1);
        while (posicionAlterna.getFila() > 0 && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
            flanquea = flanquea || this.tableroReversi.getContenido(posicionAlterna).getColor() == color;
            i++;
            posicionAlterna.setFila(posicion.getFila() - i);
        }

        posicionAlterna = new Posicion(posicion.getFila(), posicion.getColumna());

        if (flanquea) {
            posicionAlterna.setFila(posicion.getFila() - 1);
            while (posicionAlterna.getFila() > posicion.getFila() - i && this.tableroReversi.getContenido(posicionAlterna).ocupado()) {
                this.tableroReversi.getContenido(posicionAlterna).setColor(color);
                j++;
                posicionAlterna.setFila(posicion.getFila() - j);
            }
        }
    }

    private boolean verificarPosicionValida(Posicion posicion) {
        Posicion posicionAlrededor = new Posicion(posicion.getFila(), posicion.getColumna());
        boolean posicionValida = false;

        if (posicion.getFila() + 1 < this.tamanioTablero) {
            posicionAlrededor.setFila(posicion.getFila() + 1);
            posicionValida = posicionValida || this.tableroReversi.getContenido(posicionAlrededor).ocupado();
        }

        if (posicion.getFila() - 1 > 0) {
            posicionAlrededor.setFila(posicion.getFila() - 1);
            posicionValida = posicionValida || this.tableroReversi.getContenido(posicionAlrededor).ocupado();
        }

        posicionAlrededor.setFila(posicion.getFila());

        if (posicion.getColumna() + 1 < this.tamanioTablero) {
            posicionAlrededor.setColumna(posicion.getColumna() + 1);
            posicionValida = posicionValida || this.tableroReversi.getContenido(posicionAlrededor).ocupado();
        }

        if (posicion.getColumna() - 1 > 0) {
            posicionAlrededor.setColumna(posicion.getColumna() - 1);
            posicionValida = posicionValida || this.tableroReversi.getContenido(posicionAlrededor).ocupado();
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
