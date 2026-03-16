

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste FogaoTest.
 *
 * @author  Gonçalo Barracha, Rodrigo Cardoso
 * @version 26/05/2024
 */
public class FogaoTest
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
        assertEquals(f.energyOn, false);
        assertEquals(f.getTipo(), Tipo.ENERGIA);
    }
    @Test
    public void testReset(){
        c.addEquipamento(f);
        c.addEquipamento(de);
        de.setFogao(f);
        f.act();
        f.reset();
        assertEquals(f.energyOn, false);
    }
    @Test
    public void testAct(){
        c.addEquipamento(f);
        c.addEquipamento(de);
        de.setFogao(f);
        f.act();
        assertEquals(f.energyOn, true);
    }
}
