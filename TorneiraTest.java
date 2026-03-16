

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste TorneiraTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class TorneiraTest
{
    Torneira t;
    DetetorDeAgua da;
    Compartimento c;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        t = new Torneira();
        da = new DetetorDeAgua();
        c = new Compartimento("Quarto de Hospedes");
    }
    @Test
    public void testConstructor(){
        assertEquals(t.isWatterOpen(), false);
        assertEquals(t.getTipo(), Tipo.AGUA);
    }
    @Test
    public void testReset(){
        c.addEquipamento(t);
        t.act();
        t.reset();
        assertEquals(t.isWatterOpen(),false);
    }
    @Test
    public void act(){
        c.addEquipamento(t);
        t.act();
        assertEquals(t.isWatterOpen(),true);
    }
}
