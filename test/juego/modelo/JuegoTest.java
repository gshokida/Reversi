package juego.modelo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class JuegoTest {
    @Test
    public void nuevoJuego_empiezaVacio() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Juego juego = new Juego(jugadorUno, jugadorDos);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Posicion posicion = new Posicion(i, j);
                assertFalse(juego.getContenido(posicion).ocupado());
            }
        }
    }
}
