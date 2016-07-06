package juego.modelo;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Ficha;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by German on 05/07/2016.
 */
public class CasilleroTest {
    @Test
    public void nuevoCasillero_noEstaOcupado() {
        Casillero casillero = new Casillero();
        assertEquals(false, casillero.ocupado());
    }

    @Test
    public void casilleroConFichaBlanca_estaOcupado() {
        Casillero casillero = new Casillero();
        casillero.setContenido(new Ficha(ColorBlanco.getInstance()));
        assertEquals(true, casillero.ocupado());
    }

    @Test
    public void casilleroConFichaNegra_estaOcupado() {
        Casillero casillero = new Casillero();
        casillero.setContenido(new Ficha(ColorNegro.getInstance()));
        assertEquals(true, casillero.ocupado());
    }

    @Test
    public void casilleroConFichaBlanca_guardaFichaBlanca() {
        Casillero casillero = new Casillero();
        Ficha ficha = new Ficha(ColorBlanco.getInstance());
        casillero.setContenido(ficha);
        assertEquals(ficha, casillero.getContenido());
    }

    @Test
    public void casilleroConFichaNegra_guardaFichaNegra() {
        Casillero casillero = new Casillero();
        Ficha ficha = new Ficha(ColorNegro.getInstance());
        casillero.setContenido(ficha);
        assertEquals(ficha, casillero.getContenido());
    }
}
