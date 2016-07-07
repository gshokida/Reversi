package juego.modelo.contenido;

/**
 * Created by German on 05/07/2016.
 */
public class ContenidoVacio implements Contenido {

    public boolean ocupado() {
        return false;
    }

    public Color getColor() {
        return SinColor.getInstance();
    }

    public void setColor(Color color) {

    }
}
