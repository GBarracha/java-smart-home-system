/**
 * Esta classe permite criar um Equipamento especifico, um ArCondicionado.
 * Este Equipamento vai possibilitar a alteração da Temperatura de um Compartimento.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class ArCondicionado extends Temperatura implements Atuador
{
    /**
     * Construtor da classe ArCondicionado, vai instanciar um Equipamento - ArCondicionado,
     * com os atributos da classe Temperatura.
     */
    public ArCondicionado(){
        super();
    }
    /**
     * Método que permite alterar a temperatura do ArCondicionado
     * 
     * @param temperature - Valor da temperatura que quer colocar no ArCondicionado
     */
    public void changeTemperature(double temperature){
        if(temperature <= super.MAX && temperature >= super.MIN){
            super.temperature = temperature;
        }
    }
    /**
     * Método que permite fazer reset à temperatura do Compartimento,
     * colocando-o com o valor de origem 25.0ºC
     */
    @Override
    public void reset(){
        super.temperature = 25.0;
    }
    /**
     * Método que permite simular a utilização do ArCondicionado num Compartimento
     * Para o utilizar deve:
     * Definir a temperatura no método changeTemperature()
     * Instanciar um objeto Termometro no Compartimento a ser simulado
     * Feito isto será simulado e verá a atualização da Temperatura
     */
    @Override
    public void act(){
        double newTemperature = this.temperature;
        for (Equipamento temp : this.getCompartimento().getAllEquipamentos()){
            if(temp.getId() != this.getId()){//iterador?
                if (temp instanceof Termometro){
                    Termometro termometro = (Termometro) temp;
                        termometro.temperature= newTemperature;
                    }
                }
            }
    }
    /**
     * Método toString da descrição do ArCondicionado.
     * 
     * @return String - Descrição completa do ArCondicionado
     */
    @Override
    public String toString(){
        String str = "";
        str += "Ar Condicionado \n ID: "+getId();
        str += "\n Temperatura AC: "+getTemperature()+"\n";
        return str;
    }
}
