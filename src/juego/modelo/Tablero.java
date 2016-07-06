package juego.modelo;

import juego.modelo.contenido.Contenido;
import juego.modelo.contenido.ContenidoVacio;

/**
 * Created by German on 05/07/2016.
 */
public class Tablero {
    private int columnas = 8;
    private int filas = 8;
    private Casillero tablero[][];

    public Tablero() {
        this.tablero = new Casillero[this.filas][this.columnas];

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                this.tablero[i][j] = new Casillero();
    }

    public Contenido getContenido(Posicion posicion) {
        return this.tablero[posicion.getFila()][posicion.getColumna()].getContenido();
    }
}
