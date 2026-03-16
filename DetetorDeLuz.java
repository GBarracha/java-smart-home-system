/**
 * Esta classe permite criar um Equipamento especifico, um Detetor De Luz.
 * Este Equipamento vai fazer a leitura de um Compartimento e verificar se tem a luz acesa ou apagada.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class DetetorDeLuz extends Luz implements Sensor
{
    public DetetorDeLuz(){
        super();
    }
    /**
     * Método que permite fazer reset à luz do Compartimento,
     * deixando-o com a luz apagada
     */
    @Override
    public void reset(){
        super.lightOn = false;
    }
    /**
     * Método que permite fazer a leitura ao Compartimento se existe luz acesa.
     * Caso não existam interruptores no mesmo compartimento deste Detetor de Luz,
     * devolve que a luz está desligada.
     */
    @Override
    public void read() {
        for (Equipamento l : this.getCompartimento().getAllEquipamentos()) {
            if (l instanceof InterruptorDeLampada) {
                    if (((InterruptorDeLampada)l).isLightOn()) {
                        System.out.println("Luz ligada");
                        this.setLightOn();
                        break;
                    } else {
                        System.out.println("Luz Desligada");
                        this.setLightOff();
                    }
                }else{
                this.setLightOff();
            }
            }

    }
    /**
     * Método toString da descrição do DetetorDeLuz
     * 
     * @return String - Descrição completa do DetetorDeLuz
     */
    @Override
    public String toString(){
        String str = "";
        str += "Detetor de Luz \n ID: "+getId();
        if(super.lightOn ==  true){
            str += "\n Luz Ligada \n\n";
        }else{
            str += "\n Luz Desligada \n\n";
        }
        return str;
    }
}   
