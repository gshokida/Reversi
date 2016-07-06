package juego.modelo;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Ficha;
import juego.modelo.exceptions.PosicionNoValidaNoSePuedeAgregarFichaException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by German on 05/07/2016.
 */
public class TableroTest {
    @Test
    public void nuevoTableroInstanciaCasillerosVacios() {
        Tablero tablero = new Tablero(8);

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
        Tablero tablero = new Tablero(8);
        Ficha ficha = new Ficha(ColorNegro.getInstance());

        try {
            tablero.setContenido(ficha, posicion);
        } catch (PosicionNoValidaNoSePuedeAgregarFichaException e) {
            fail();
        }

        assertEquals(ficha, tablero.getContenido(posicion));
    }

    @Test
    public void tableroAgregarContenidoFichaBlanca() {
        Posicion posicion = new Posicion(4, 4);
        Tablero tablero = new Tablero(8);
        Ficha ficha = new Ficha(ColorBlanco.getInstance());

        try {
            tablero.setContenido(ficha, posicion);
        } catch (PosicionNoValidaNoSePuedeAgregarFichaException e) {
            fail();
        }

        assertEquals(ficha, tablero.getContenido(posicion));
    }

    @Test
    public void nuevoTableroEstaVacio() {
        Tablero tablero = new Tablero(8);

        assertEquals(true, tablero.estaVacio());
    }

    @Test
    public void tableroAgregarContenidoNoEstaVacio() {
        Posicion posicion = new Posicion(4, 4);
        Tablero tablero = new Tablero(8);
        Ficha ficha = new Ficha(ColorBlanco.getInstance());

        try {
            tablero.setContenido(ficha, posicion);
        } catch (PosicionNoValidaNoSePuedeAgregarFichaException e) {
            fail();
        }

        assertEquals(false, tablero.estaVacio());
    }

    @Test(expected=PosicionNoValidaNoSePuedeAgregarFichaException.class)
    public void tableroAgregarContenidoEnColumnaMayorAlLimite() throws PosicionNoValidaNoSePuedeAgregarFichaException {
        Posicion posicion = new Posicion(4, 8);
        Tablero tablero = new Tablero(8);
        Ficha ficha = new Ficha(ColorBlanco.getInstance());

        tablero.setContenido(ficha, posicion);
    }
}
