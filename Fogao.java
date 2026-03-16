/**
 * Esta classe permite criar um Equipamento especifico, um Fogao.
 * Este Equipamento vai permitir ligar e desligar o fogao, atualizando o estado
 * de ligado para desligado simultaneamente.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 21/05/2024
 */
public class Fogao extends Energia implements Atuador
{
    private DetetorDeEnergia energia;
    /**
     * Construtor da classe Fogao, vai instanciar um Equipamento - Fogao,
     * com os atributos da classe Energia.
     */
    public Fogao(){
        super();
    }
    /**
     * Método que permite fazer reset ao Fogao de um Compartimento,
     * colocando o Fogao por omissão como desligado
     */
    @Override
    public void reset(){
        super.energyOn = false;
    }
    /**
     * Método que permite ligar e desligar o Fogao.
     * Caso esteja ligado, ele altera o valor e desliga o fogao.
     * Caso esteja desligado, ele altera o valor e liga o fogao.
     */
    @Override
    public void act(){
        if(super.isEnergyOn()){
            super.setEnergyOff();
        }else{
            super.setEnergyOn();
        }
    }
    public DetetorDeEnergia getDetetorDeEnergia(){
        return this.energia;
    }
    public void setDetetorDeEnergia(DetetorDeEnergia detetor){
        this.energia = detetor;
    }
    /**
     * Método toString da descrição do Fogao
     * 
     * @return String - Descrição completa do Fogao
     */
    @Override
    public String toString(){
        String str = "";
        str += "Fogão \n ID: "+getId();
        if(super.energyOn == true){
            str += "\n Ligado \n";
        }else{
            str += "\n Desligado \n";
        }
        return str;
    }
}
