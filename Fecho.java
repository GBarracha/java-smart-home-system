import java.util.List;
import java.util.ArrayList;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Fecho
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 17/05/2024
 */
public abstract class Fecho extends Equipamento
{
    public boolean open;
    private static List<Fecho> allInstances = new ArrayList<>();
    /**
     * Construtor da classe Fecho, que define, o tipo de Equipamento
     * e por omissão deixa o trinco aberto.
     * Inicializa uma lista com os Equipamentos do Tipo Fecho.
     */
    public Fecho(){
        super();
        super.setTipo(Tipo.FECHO);
        this.open = true;
        allInstances.add(this);
    }
    /**
     * Método que permite verificar se o trinco está fechado ou aberto
     * 
     * @return Boolean - Retorna true se estiver aberto e false se estiver fechado
     */
    public boolean isOpen(){
        if(this.open == false){
            return false;
        }else{
            return true;
        }
    }
    /**
     * Método que permite fechar o trinco
     */
    public void setClose(){
        this.open = false;
    }
    /**
     * Método que permite abrir o trinco
     */
    public void setOpen(){
        this.open = true;
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Fecho
     * 
     * @return List<Fecho> - Equipamentos do Tipo Fecho
     */
    public static List<Fecho> getAllInstances() {
        return allInstances;   
    }
}