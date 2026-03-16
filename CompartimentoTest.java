

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CompartimentoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 27/05/2024
 */
public class CompartimentoTest
{
    Compartimento c;
    Consola cl;
    Torneira t;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        c = new Compartimento("Sala");
        cl = new Consola("X");
        t = new Torneira();
    }
    @Test
    public void testConstructor(){
        assertEquals(c.getDesignacao(), "Sala");
    }
    @Test
    public void testAssociate(){
        c.associateCompartimentoToConsola(cl);
        
        assertEquals(c.isAssociate(), true);
    }
    @Test
    public void testSetDesignacao(){
        c.setDesignacao("Quarto");
        assertEquals(c.getDesignacao(),"Quarto");
    }
    @Test
    public void testAddEquipamento(){
        c.addEquipamento(t);
        assertEquals(c.getAllEquipamentos().isEmpty(),false);
    }
}
