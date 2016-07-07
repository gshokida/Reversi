package juego.modelo.tablero;

import juego.modelo.contenido.Contenido;
import juego.modelo.contenido.ContenidoVacio;
import juego.modelo.contenido.Ficha;

/**
 * Created by German on 05/07/2016.
 */
public class Casillero {
    private Contenido contenido;

    public Casillero() {
        this.contenido = new ContenidoVacio();
    }

    public boolean ocupado() {
        return this.contenido.ocupado();
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Contenido getContenido() {
        return this.contenido;
    }
}
