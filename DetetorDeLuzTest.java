

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste DetetorDeLuzTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class DetetorDeLuzTest
{
    private DetetorDeLuz dl;
    private InterruptorDeLampada il;
    private Compartimento c;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        dl = new DetetorDeLuz();
        il = new InterruptorDeLampada();
        c = new Compartimento("Quarto");
    }
    @Test
    public void testContructor(){
        assertEquals(dl.isLightOn(),false);
        assertEquals(dl.getTipo(),Tipo.LUZ);
    }
    @Test
    public void testReset(){
        c.addEquipamento(il);
        c.addEquipamento(dl);
        il.act();
        dl.reset();
        assertEquals(dl.isLightOn(),false);
    }
}
