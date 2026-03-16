

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste ArCondicionadoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class ArCondicionadoTest
{
    private ArCondicionado a;
    private Termometro t1;
    private Compartimento c1;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        a = new ArCondicionado();
        t1 = new Termometro();
        c1 = new Compartimento("Sala");
    }
    @Test
    public void testConstructor(){
        assertEquals(a.getTemperature(),25.0);
        assertEquals(a.getTipo(), Tipo.TEMPERATURA);
    }
    @Test
    public void testChangeTemperature(){
        a.changeTemperature(30.0);
        assertEquals(a.getTemperature(),30.0);
    }
    @Test
    public void testReset(){
        a.changeTemperature(40.0);
        a.reset();
        assertEquals(a.getTemperature(),25.0);
    }
    @Test
    public void testAct(){
        c1.addEquipamento(a);
        c1.addEquipamento(t1);
        a.changeTemperature(45.0);
        t1.read();
        a.act();
        assertEquals(t1.getTemperature(),45.0);
    }
}
