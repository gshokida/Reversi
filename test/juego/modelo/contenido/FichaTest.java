package juego.modelo.contenido;

import juego.modelo.contenido.ColorBlanco;
import juego.modelo.contenido.ColorNegro;
import juego.modelo.contenido.Ficha;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by German on 05/07/2016.
 */
public class FichaTest {
    @Test
    public void nuevaFichaColorBlanco_esBlanco(){
        Ficha ficha = new Ficha(ColorBlanco.getInstance());
        assertEquals(ColorBlanco.getInstance(), ficha.getColor());
    }

    @Test
    public void nuevaFichaColorNegro_esNegro(){
        Ficha ficha = new Ficha(ColorNegro.getInstance());
        assertEquals(ColorNegro.getInstance(), ficha.getColor());
    }

    @Test
    public void voltearFichaBlanca_seConvierteEnNegra() throws Exception {
        Ficha ficha = new Ficha(ColorBlanco.getInstance());
        ficha.voltear();
        assertEquals(ColorNegro.getInstance(), ficha.getColor());
    }

    @Test
    public void voltearFichaNegra_seConvierteEnBlanca() throws Exception {
        Ficha ficha = new Ficha(ColorNegro.getInstance());
        ficha.voltear();
        assertEquals(ColorBlanco.getInstance(), ficha.getColor());
    }
}
