package juego.modelo.contenido;

/**
 * Created by German on 05/07/2016.
 */
public class Ficha implements Contenido {
    private Color color;

    public Ficha(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void voltear() {
        if (this.color.esIgual(ColorBlanco.getInstance()))
            this.color = ColorNegro.getInstance();
        else
            this.color = ColorBlanco.getInstance();
    }

    public boolean ocupado() {
        return true;
    }
}
