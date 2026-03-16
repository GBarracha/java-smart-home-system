/**
 * Esta classe permite criar um Equipamento especifico, um Interruptor de Lampâda.
 * Este Equipamento vai permitir ativar e desativar o interruptor, atualizando o estado
 * da luz simultaneamente.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class InterruptorDeLampada extends Luz implements Atuador
{
    /**
     * Construtor da classe InterruptorDeLampada, vai instanciar um Equipamento - InterruptorDeLampada,
     * com os atributos da classe Luz.
     */
    public InterruptorDeLampada(){
        super();
    }
    /**
     * Método que permite fazer reset à luz do Compartimento,
     * deixando-o com a luz apagada, ou seja, desativa o interruptor.
     */
    @Override
    public void reset(){
        super.lightOn = false;
    }
    /**
     * Método que permite ativar e desativar o Interruptor.
     * Caso a luz esteja acesa, ele irá desativar o interruptor, apagando a luz
     * Caso a luz esteja apagada, ele vai ativar o interruptor, acendendo a luz
     */
    @Override
    public void act(){
        if(super.isLightOn()){
            super.setLightOff();
        }else{
            super.setLightOn();
        }
    }
    /**
     * Método toString da descrição do InterruptorDeLampada
     * 
     * @return String - Descrição completa do InterruptorDeLampada
     */
    @Override
    public String toString(){
        String str = "";
        str += "Interruptor de Lampada \n ID: "+getId();
        if(super.lightOn == true){
            str += "\n Interruptor Aberto \n";
        }else{
            str += "\n Interruptor Fechado \n";
        }
        return str;
    }
}
