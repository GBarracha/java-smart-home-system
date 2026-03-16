/**
 * Esta classe permite criar um Equipamento especifico, um Detetor De Água.
 * Este Equipamento vai fazer a leitura de um Compartimento e verificar se tem alguma torneira aberta.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 21/05/2024
 */
public class DetetorDeAgua extends Agua implements Sensor
{
    /**
     * Construtor da classe DetetorDeAgua, vai instanciar um Equipamento - DetetorDeAgua
     * com os atricutos da classe Agua.
     */
    public DetetorDeAgua(){
        super();
    }
    /**
     * Método que permite fazer reset à água do Compartimento,
     * deixando-o com a água fechada
     */
    @Override
    public void reset(){
        super.watter = false;
    }
    /**
     * Método que permite fazer a leitura ao Compartimento se existe alguma torneira aberta.
     * Caso não existam torneiras no mesmo compartimento deste Detetor de Água,
     * devolve que a água está fechada.
     */
    @Override
    public void read() {
        boolean torneiraFound = false;
        for (Equipamento a : getCompartimento().getAllEquipamentos()) {
            if (a.getCompartimento() != null && a.getCompartimento().equals(this.getCompartimento())) {
                if (a instanceof Torneira) {
                    if (((Torneira) a).isWatterOpen()) {
                        System.out.println("Água aberta");
                        this.setWatterOpen();
                        torneiraFound = true;
                        break;
                    }else {
                        System.out.println("Água fechada");
                        this.setWatterClose();
                        torneiraFound = true;
                    }
                }
            }
        }
        if (!torneiraFound) {
            System.out.println("Água fechada");
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
        str += "Detetor de Água \n ID: "+getId();
        if(super.isWatterOpen()){
            str += "\n Água aberta \n\n";
        }else{
            str += "\n Água fechada \n\n";
        }
        return str;
    }
}   
