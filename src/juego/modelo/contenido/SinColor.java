package juego.modelo.contenido;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class SinColor implements Color {
    private static Color instancia;

    private SinColor(){

    }

    public static Color getInstance(){
        if (SinColor.instancia == null)
            SinColor.instancia = new SinColor();

        return SinColor.instancia;
    }

    public boolean esIgual(Color color) {
        return this.instancia.equals(color);
    }
}
