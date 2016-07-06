package juego.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class TurnoTest {
    @Test
    public void nuevoTurnoDevuelveJugadorFichasNegras() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Turno turno = new Turno(jugadorUno, jugadorDos);

        assertEquals(turno.getJugadorActual(), jugadorUno);
    }
}
