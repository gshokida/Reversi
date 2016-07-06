package juego.modelo.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class ColaTest {
    @Test
    public void nuevaCola_estaVacia(){
        Cola<String> cola = new Cola<String>();
        assertFalse(cola.hasItems());
    }

    @Test
    public void nuevaCola_tamanioCero(){
        Cola<String> cola = new Cola<String>();
        assertEquals(cola.size(), 0);
    }

    @Test
    public void encolarItem_SumaUnoAlTamanio(){
        Cola<String> cola = new Cola<String>();

        cola.enqueue("primero");

        int tamanio = cola.size();

        cola.enqueue("hola");

        assertEquals(cola.size(), tamanio + 1);
    }

    @Test
    public void desencolarItem_RestaUnoAlTamanio(){
        Cola<String> cola = new Cola<String>();

        cola.enqueue("primero");
        cola.enqueue("hola");

        int tamanio = cola.size();

        String dequeue = cola.dequeue();

        assertEquals(cola.size(), tamanio - 1);
    }
}
