package juego.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by German on 05/07/2016.
 */
public class TableroTest {
    @Test
    public void nuevoTableroInstanciaCasillerosVacios() {
        Tablero tablero = new Tablero();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Posicion posicion = new Posicion(i, j);
                assertEquals(false, tablero.getContenido(posicion).ocupado());
            }
        }
    }
}
