package juego.modelo.juego;

import juego.modelo.juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class JugadorTest {
    @Test
    public void nuevoJugador_mantieneElNombre() {
        Jugador jugador = new Jugador("nombre");
        assertTrue("nombre" == jugador.getNombre());
    }
}
