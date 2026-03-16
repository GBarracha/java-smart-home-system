

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste EstoreEletricoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class EstoreEletricoTest
{
    EstoreEletrico e;
    Compartimento c;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        e = new EstoreEletrico();
        c = new Compartimento("Sala de Jantar");
    }
    @Test
    public void testConstructor(){
        assertEquals(e.getTipo(),Tipo.POSICAO);
        assertEquals(e.getPositionFromList(), ListaPosicoes.OPEN);
    }
    @Test
    public void testSetPosition(){
        e.setPosition(3);
        assertEquals(e.getPosition(),3);
    }
    @Test
    public void testGetPosition(){
        assertEquals(e.getPosition(),1);
    }
    @Test
    public void testReset(){
        e.setPosition(3);
        e.reset();
        assertEquals(e.getPositionFromList(),ListaPosicoes.OPEN);
    }
    @Test
    public void testAct(){
        e.setPosition(3);
        e.act();
        assertEquals(e.getPositionFromList(),ListaPosicoes.HALF_OPEN);
    }
}
