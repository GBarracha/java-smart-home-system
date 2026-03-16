

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste DetetorDeFechoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class DetetorDeFechoTest
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
        assertEquals(df.open,true);
        assertEquals(df.getTipo(),Tipo.FECHO);
    }
    @Test
    public void testReset(){
        t.act();
        df.reset();
        assertEquals(df.open,true);
    }
}
