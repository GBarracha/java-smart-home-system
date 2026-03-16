/**
 * Esta classe permite criar um Equipamento especifico, um Termômetro.
 * Este Equipamento vai possibilitar fazer a leitura da Temperatura num dado Compartimento.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class Termometro extends Temperatura implements Sensor
{
    private boolean simulated;
    /**
     * Construtor da classe Termometro, vai instanciar um Equipamento - Termômetro,
     * com os atributos da classe Temperatura.
     */
    public Termometro(){
        super();
    }
    public boolean isSimulated(){
        return simulated;
    }
    /**
     * Método que permite fazer reset à temperatura do Compartimento,
     * colocando-o com o valor de origem 25.0ºC
     */
    @Override
    public void reset(){
        super.temperature = 25.0;
        this.simulated = false;
    }
    /**
     * Método que permite obter a temperatura atual do Compartimento
     * onde o mesmo está instalado
     */
    @Override
    public void read(){
        System.out.println("Temperatura: "+super.getTemperature()+" ºc");
        this.simulated = true;
    }
    /**
     * Método toString da descrição do Termômetro.
     * 
     * @return String - Descrição completa do Termômetro
     */
    @Override
    public String toString(){
        String str = "";
        str += "Termometro \n ID: "+getId();
        str += "\n Temperatura Termometro: "+getTemperature()+"\n\n";
        return str;
    }
}