package juego.modelo;

import juego.modelo.exceptions.CasilleroOcupadoNoSePuedeAgregarFichaException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

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

    @Test
    public void nuevoJuego_empiezaConJugadorFichasNegras() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Juego juego = new Juego(jugadorUno, jugadorDos);

        assertEquals(jugadorUno, juego.getJugadorActual());
    }

    @Test
    public void nuevoJuego_pasoTurno_JugadorFichasBlancas() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Juego juego = new Juego(jugadorUno, jugadorDos);
        Posicion posicion = new Posicion(4, 4);

        try {
            juego.setFicha(posicion);
        } catch (CasilleroOcupadoNoSePuedeAgregarFichaException e) {
            fail();
        }

        assertEquals(jugadorDos, juego.getJugadorActual());
    }

    @Test
    public void nuevoJuego_pasoTurno_VerificoPosicionDeLaFicha() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Juego juego = new Juego(jugadorUno, jugadorDos);
        Posicion posicion = new Posicion(4, 4);

        try {
            juego.setFicha(posicion);
        } catch (CasilleroOcupadoNoSePuedeAgregarFichaException e) {
            fail();
        }

        assertEquals(true, juego.getContenido(posicion).ocupado());
    }
}
