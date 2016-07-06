package juego.modelo;

import juego.modelo.contenido.Contenido;
import juego.modelo.contenido.ContenidoVacio;
import juego.modelo.exceptions.PosicionNoValidaNoSePuedeAgregarFichaException;

/**
 * Created by German on 05/07/2016.
 */
public class Tablero {
    private int tamanioTablero;
    private Casillero tablero[][];

    public Tablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
        this.tablero = new Casillero[this.tamanioTablero][this.tamanioTablero];

        for (int i = 0; i < this.tamanioTablero; i++)
            for (int j = 0; j < this.tamanioTablero; j++)
                this.tablero[i][j] = new Casillero();
    }

    public Contenido getContenido(Posicion posicion) {
        return this.tablero[posicion.getFila()][posicion.getColumna()].getContenido();
    }

    public void setContenido(Contenido contenido, Posicion posicion) throws PosicionNoValidaNoSePuedeAgregarFichaException {
        if (posicion.getFila() > this.tamanioTablero - 1 || posicion.getColumna() > this.tamanioTablero - 1)
            throw new PosicionNoValidaNoSePuedeAgregarFichaException();

        this.tablero[posicion.getFila()][posicion.getColumna()].setContenido(contenido);
    }

    public boolean estaVacio() {
        boolean estaOcupado = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Posicion posicion = new Posicion(i, j);
                estaOcupado = estaOcupado || this.getContenido(posicion).ocupado();
            }
        }

        return !estaOcupado;
    }
}
