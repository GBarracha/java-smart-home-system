import java.util.Random;
import java.util.List;
import java.util.ArrayList;
/**
 * Esta classe permite fazer a definição generalizada dos Equipamentos do Tipo Temperatura 
 * Inclui o construtor e métodos que serão utilizados pelas classes especializadas
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 17/05/2024
 */
public abstract class Temperatura extends Equipamento{
    protected double temperature;
    protected static final double MIN = -50.0;
    protected static final double MAX = 50.0;
    private static List<Temperatura> allInstances = new ArrayList<>();
    /**
     * Construtor da classe Temperatura, que define, o tipo de Equipamento
     * e a temperatura por omissão.
     * Inicializa uma lista com os Equipamentos do Tipo Temperatura.
     */
    public Temperatura()
    {
        super();
        super.setTipo(Tipo.TEMPERATURA);
        this.temperature = 25.0;
        allInstances.add(this);
    }
    /**
     * Método que devolve a temperatura do Equipamento
     * 
     * @return Double - Valor da temperatura
     */
    public double getTemperature(){
        return this.temperature;
    }
    /**
     * Método que altera a temperatura de um Equipamento, assumindo que:
     * A temperatura não pode ser superior a 50.0ºC
     * A temperatura não pode ser inferior a -50.0ºC
     * 
     * @param temperatura - Temperatura que queremos atribuir ao Equipamento
     */
    public void setTemperature(double temperatura){
        if(temperature <= MAX && temperature >= MIN){
            this.temperature = temperature;
        }
    }
    /**
     * Método que permite listar todos os Equipamentos do Tipo Temperatura
     * 
     * @return List<Temperatura> - Equipamentos do Tipo Temperatura
     */
    public static List<Temperatura> getAllInstances() {
        return allInstances;   
    }
}