

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste DetetorDeEnergiaTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class DetetorDeEnergiaTest
{
    Fogao f;
    DetetorDeEnergia de;
    Compartimento c;
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        f = new Fogao();
        de = new DetetorDeEnergia();
        c = new Compartimento("Cozinha");
    }
    @Test
    public void testConstructor(){
        c.addEquipamento(f);
        c.addEquipamento(de);
        de.setFogao(f);
        assertEquals(de.energyOn, false);
        assertEquals(de.getTipo(), Tipo.ENERGIA);
    }
    @Test
    public void testReset(){
        c.addEquipamento(f);
        c.addEquipamento(de);
        de.setFogao(f);
        f.act();
        f.reset();
        assertEquals(de.energyOn,false);
    }
}
