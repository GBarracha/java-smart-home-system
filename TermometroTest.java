

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste TermometroTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class TermometroTest
{
    private Termometro t;
    private ArCondicionado a;
    private Compartimento c1;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        t = new Termometro();
        a = new ArCondicionado();
        c1 = new Compartimento("Sala");
    }
    @Test
    public void testConstructor(){
        assertEquals(t.getTemperature(), 25.0);
        assertEquals(t.getTipo(), Tipo.TEMPERATURA);
    }
    @Test
    public void testReset(){
        c1.addEquipamento(a);
        c1.addEquipamento(t);
        a.changeTemperature(40.0);
        a.act();
        t.reset();
        assertEquals(t.getTemperature(),25.0);
    }
    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
