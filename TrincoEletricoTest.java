

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste TrincoEletricoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class TrincoEletricoTest
{
    TrincoEletrico t;
    DetetorDeFecho df;
    Compartimento c;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        t = new TrincoEletrico();
        df = new DetetorDeFecho();
        c = new Compartimento("Cozinha");
    }
    @Test
    public void testConstructor(){
        assertEquals(t.open,true);
        assertEquals(t.getTipo(),Tipo.FECHO);
    }
    @Test
    public void testReset(){
        t.act();
        t.reset();
        assertEquals(t.open,true);
    }
    @Test
    public void testAct(){
        t.act();
        assertEquals(t.open,false);
    }
}
