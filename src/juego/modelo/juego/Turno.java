package juego.modelo.juego;

import juego.modelo.juego.Jugador;
import juego.modelo.utils.Cola;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class Turno {
    private Cola<Jugador> jugadores;

    public Turno(Jugador jugadorFichaNegra, Jugador jugadorFichaBlanca) {
        this.jugadores = new Cola<>();
        this.jugadores.enqueue(jugadorFichaNegra);
        this.jugadores.enqueue(jugadorFichaBlanca);
    }

    public Jugador getJugadorActual() {
        Jugador jugador = this.jugadores.dequeue();
        this.jugadores.enqueue(jugador);
        return jugador;
    }
}
