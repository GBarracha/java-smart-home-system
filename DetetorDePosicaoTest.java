

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste DetetorDePosicaoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class DetetorDePosicaoTest
{
    EstoreEletrico e;
    DetetorDePosicao dp;
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
        dp = new DetetorDePosicao();
        c = new Compartimento("Sala de Jantar");
        dp.setEstore(e);
    }
    @Test
    public void testConstructor(){
        assertEquals(dp.getTipo(),Tipo.POSICAO);
        assertEquals(dp.getPositionFromList(), ListaPosicoes.OPEN);
    }
    @Test
    public void testReset(){
        e.setPosition(3);
        e.act();
        dp.reset();
        assertEquals(dp.getPositionFromList(), ListaPosicoes.OPEN);
    }
}
