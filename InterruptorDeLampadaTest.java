

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste InterruptorDeLampadaTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class InterruptorDeLampadaTest
{
    private DetetorDeLuz dl;
    private InterruptorDeLampada il;
    private Compartimento c;
    /**
     * Construtor default para a classe de teste InterruptorDeLampadaTest
     */
    public InterruptorDeLampadaTest()
    {
        dl = new DetetorDeLuz();
        il = new InterruptorDeLampada();
        c = new Compartimento("Quarto");
    }
    @Test
    public void testConstructor(){
        assertEquals(il.isLightOn(),false);
        assertEquals(il.getTipo(),Tipo.LUZ);
    }
    @Test
    public void testReset(){
        il.act();
        il.reset();
        assertEquals(il.isLightOn(),false);
    }
    @Test
    public void act(){
        il.act();
        assertEquals(il.isLightOn(),true);
    }
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

}
