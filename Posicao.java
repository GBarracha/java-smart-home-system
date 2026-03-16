import java.util.List;
import java.util.ArrayList;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Posição
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 17/05/2024
 */
public abstract class Posicao extends Equipamento
{
    private static List<Posicao> allInstances = new ArrayList<>();
    private ListaPosicoes positions;
    /**
     * Construtor da classe Posicao, que define, o tipo de Equipamento
     * e por omissão deixa o Estore Elétrico aberto.
     * Inicializa uma lista com os Equipamentos do Tipo Posicao.
     */
    public Posicao(){
        super();
        super.setTipo(Tipo.POSICAO);
        this.positions = ListaPosicoes.OPEN;
        allInstances.add(this);
    }
    /**
     * Método que permite alterar a posição do Estore Elétrico, possibilidades:
     * 
     * @param ListaPosicoes - Posição que queremos colocar o Estore Elétrico
     */
    public void setPositionFromList(ListaPosicoes position){
        this.positions = position;
    }
    /**
     * Método que permite obtee a posicao de um Estore Elétrico
     * 
     * @return ListaPosicoes - Posição atual do Estore Elétrico
     */
    public ListaPosicoes getPositionFromList(){
        return positions;
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Posicao
     * 
     * @return List<Posicao> - Equipamentos do Tipo Posicao
     */
    public static List<Posicao> getAllInstances() {
        return allInstances;   
    }
}