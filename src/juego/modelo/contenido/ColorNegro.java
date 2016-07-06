package juego.modelo.contenido;

/**
 * Created by German on 05/07/2016.
 */
public class ColorNegro implements Color {
    private static Color instancia;

    private ColorNegro(){

    }

    public static Color getInstance(){
        if (ColorNegro.instancia == null)
            ColorNegro.instancia = new ColorNegro();

        return ColorNegro.instancia;
    }

    public boolean esIgual(Color color) {
        return this.instancia.equals(color);
    }
}
