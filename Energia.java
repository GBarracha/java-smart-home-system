
import java.util.List;
import java.util.ArrayList;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Energia
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 21/05/2024
 */
public abstract class Energia extends Equipamento
{
    public boolean energyOn;
    private static List<Energia> allInstances = new ArrayList<>();
    /**
     * Construtor da classe Energia, que define, o tipo de Equipamento
     * e por omissão deixa a energia desligada.
     * Inicializa uma lista com os Equipamentos do Tipo Energia.
     */
    public Energia(){
        super();
        super.setTipo(Tipo.ENERGIA);
        this.energyOn = false;
        allInstances.add(this);
    }
    /**
     * Método que permite verificar se a energia está ligada ou desligada
     * 
     * @return Boolean - Retorna true se estiver ligada e false se estiver desligada
     */
    public boolean isEnergyOn(){
        if(this.energyOn == false){
            return false;
        }else{
            return true;
        }
    }
    /**
     * Método que permite apagar a energia
     */
    public void setEnergyOff(){
        this.energyOn = false;
    }
    /**
     * Método que permite acender a energia
     */
    public void setEnergyOn(){
        this.energyOn = true;
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Energia
     * 
     * @return List<Energia> - Equipamentos do Tipo Energia
     */
    public static List<Energia> getAllInstances() {
        return allInstances;   
    }
}
