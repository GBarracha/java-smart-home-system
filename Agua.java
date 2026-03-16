import java.util.List;
import java.util.ArrayList;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Agua
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 21/05/2024
 */
public abstract class Agua extends Equipamento
{
    private static List<Agua> allInstances = new ArrayList<>();
    public boolean watter;
    /**
     * Construtor da classe Agua, que define, o tipo de Equipamento
     * e por omissão deixa a Agua fechada.
     * Inicializa uma lista com os Equipamentos do Tipo Agua.
     */
    public Agua(){
        super();
        super.setTipo(Tipo.AGUA);
        this.watter = false;
        allInstances.add(this);
    }
    /**
     * Método que permite verificar se a água está aberta ou fechada
     * 
     * @return Boolean - Retorna true se estiver aberta e false se estiver fechada
     */
    public boolean isWatterOpen(){
        if(this.watter == false){
            return false;
        }else{
            return true;
        }
    }
    /**
     * Método que permite fechar a água de uma torneira
     */
    public void setWatterClose(){
        this.watter = false;
    }
    /**
     * Método que permite abrir a água de uma torneira
     */
    public void setWatterOpen(){
        this.watter = true;
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Agua
     * 
     * @return List<Agua> - Equipamentos do Tipo Agua
     */
    public static List<Agua> getAllInstances() {
        return allInstances;   
    }
}