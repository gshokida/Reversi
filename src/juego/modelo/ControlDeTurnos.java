package juego.modelo;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class ControlDeTurnos {
    private Turno turno;
    private Jugador jugadorActual;

    public ControlDeTurnos(Jugador jugadorFichaNegra, Jugador jugadorFichaBlanca) {
        this.turno = new Turno(jugadorFichaNegra, jugadorFichaBlanca);
        this.jugadorActual = this.turno.getJugadorActual();
    }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }

    public void pasarTurno() {
        this.jugadorActual = this.turno.getJugadorActual();
    }
}
