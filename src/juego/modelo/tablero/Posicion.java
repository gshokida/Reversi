package juego.modelo.tablero;

/**
 * Created by German on 05/07/2016.
 */
public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
