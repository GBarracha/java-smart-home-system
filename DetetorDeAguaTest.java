

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste DetetorDeAguaTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class DetetorDeAguaTest
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
    public void testContructor(){
        assertEquals(da.isWatterOpen(),false);
        assertEquals(da.getTipo(),Tipo.AGUA);
    }
    @Test
    public void testReset(){
        c.addEquipamento(t);
        c.addEquipamento(da);
        t.act();
        da.reset();
        assertEquals(da.isWatterOpen(),false);
    }
}
