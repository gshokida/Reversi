package juego.modelo.juego;

import juego.modelo.juego.ControlDeTurnos;
import juego.modelo.juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class ControlDeTurnosTest {
    @Test
    public void nuevoControlDeTurnos_obtengoTurnoDeJugadorFichasNegras() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");

        ControlDeTurnos control = new ControlDeTurnos(jugadorUno, jugadorDos);

        assertEquals(jugadorUno, control.getJugadorActual());
    }

    @Test
    public void nuevoControlDeTurnos_obtengoTurnoDeJugadorFichasNegrasDosVecesMantieneJugador() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");

        ControlDeTurnos control = new ControlDeTurnos(jugadorUno, jugadorDos);
        control.getJugadorActual();

        assertEquals(jugadorUno, control.getJugadorActual());
    }

    @Test
    public void controlDeTurnos_pasarTurnoCambiaDeJugador() {
        Jugador jugadorUno = new Jugador("NombreUno");
        Jugador jugadorDos = new Jugador("NombreDos");

        ControlDeTurnos control = new ControlDeTurnos(jugadorUno, jugadorDos);

        assertEquals(jugadorUno, control.getJugadorActual());

        control.pasarTurno();

        assertEquals(jugadorDos, control.getJugadorActual());
    }
}
