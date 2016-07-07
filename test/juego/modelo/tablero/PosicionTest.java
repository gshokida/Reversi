package juego.modelo.tablero;

import juego.modelo.tablero.Posicion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by German on 05/07/2016.
 */
public class PosicionTest {
    @Test
    public void nuevaPosicion_mantieneLosValores(){
        Posicion posicion = new Posicion(0, 0);
        assertEquals(0, posicion.getColumna());
        assertEquals(0, posicion.getFila());
    }

    @Test
    public void nuevaPosicion_mantieneLosValoresDisntintos(){
        Posicion posicion = new Posicion(1, 3);
        assertEquals(3, posicion.getColumna());
        assertEquals(1, posicion.getFila());
    }

    @Test
    public void nuevaPosicion_cambioLaFila(){
        Posicion posicion = new Posicion(1, 3);
        assertEquals(3, posicion.getColumna());
        assertEquals(1, posicion.getFila());

        posicion.setFila(2);
        assertEquals(2, posicion.getFila());
    }

    @Test
    public void nuevaPosicion_cambioLaColumna(){
        Posicion posicion = new Posicion(1, 3);
        assertEquals(3, posicion.getColumna());
        assertEquals(1, posicion.getFila());

        posicion.setColumna(2);
        assertEquals(2, posicion.getColumna());
    }
}
