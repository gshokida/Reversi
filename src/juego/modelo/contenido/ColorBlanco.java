package juego.modelo.contenido;

/**
 * Created by German on 05/07/2016.
 */
public class ColorBlanco implements Color {
    private static Color instancia;

    private ColorBlanco(){

    }

    public static Color getInstance(){
        if (ColorBlanco.instancia == null)
            ColorBlanco.instancia = new ColorBlanco();

        return ColorBlanco.instancia;
    }

    public boolean esIgual(Color color) {
        return this.instancia.equals(color);
    }
}
