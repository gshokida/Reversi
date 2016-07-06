package juego.modelo;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Ficha;
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

    @Test
    public void tableroAgregarContenido() {
        Posicion posicion = new Posicion(4, 4);
        Tablero tablero = new Tablero();
        Ficha ficha = new Ficha(ColorNegro.getInstance());

        tablero.setContenido(ficha, posicion);

        assertEquals(ficha, tablero.getContenido(posicion));
    }

    @Test
    public void tableroAgregarContenidoFichaBlanca() {
        Posicion posicion = new Posicion(4, 4);
        Tablero tablero = new Tablero();
        Ficha ficha = new Ficha(ColorBlanco.getInstance());

        tablero.setContenido(ficha, posicion);

        assertEquals(ficha, tablero.getContenido(posicion));
    }
}
