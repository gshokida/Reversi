package juego.modelo.juego;

import juego.modelo.juego.Jugador;
import juego.modelo.juego.Turno;
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

    @Test
    public void turnoDevuelveJugadorFichasNegras() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");
        Turno turno = new Turno(jugadorUno, jugadorDos);

        turno.getJugadorActual();

        assertEquals(turno.getJugadorActual(), jugadorDos);
    }
}
