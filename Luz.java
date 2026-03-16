import java.util.ArrayList;
import java.util.List;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Luz
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 17/05/2024
 */
public abstract class Luz extends Equipamento
{
    public boolean lightOn;
    private static List<Luz> allInstances = new ArrayList<>();
    /**
     * Construtor da classe Luz, que define, o tipo de Equipamento
     * e por omissão deixa a luz desligada.
     * Inicializa uma lista com os Equipamentos do Tipo Luz.
     */
    public Luz()
    {
        super();
        super.setTipo(Tipo.LUZ);
        this.lightOn=false;
        allInstances.add(this);
    }
    /**
     * Método que permite verificar se a luz está acesa ou apagada
     * 
     * @return Boolean - Retorna true se estiver ligada e false se estiver desligada
     */
    public boolean isLightOn(){
        if(this.lightOn == false){
            return false;
        }else{
            return true;
        }
    }
    /**
     * Método que permite apagar a luz de um Interruptor
     */
    public void setLightOff(){
        this.lightOn = false;
    }
    /**
     * Método que permite acender a luz de um Interruptor
     */
    public void setLightOn(){
        this.lightOn = true;
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Luz
     * 
     * @return List<Luz> - Equipamentos do Tipo Luz
     */
    public static List<Luz> getAllInstances() {
        return allInstances;   
    }
}