
/**
 * Esta classe permite criar um Equipamento especifico, um Detetor de Energia.
 * Este Equipamento vai fazer a leitura de um Fogao e verificar se este está ligado ou desligado
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 21/05/2024
 */
public class DetetorDeEnergia extends Energia implements Sensor
{
    private Fogao fogao;
    /**
     * Construtor da classe DetetorDeEnergia, vai instanciar um Equipamento - DetetorDeEnergia,
     * com os atributos da classe Energia.
     */
    public DetetorDeEnergia(){
        super();
    }
    /**
     * Método que permite associar este Detetor a um Fogao.
     * Garanta que cada Detetor só tenha 1 Fogao
     * 
     * @param fogao - Fogao a ser associado a este DetetorDeEnergia
     */
    public void setFogao(Fogao fogao){
        this.fogao = fogao;
    }

    public Fogao getFogao(){
        return this.fogao;
    }
    /**
     * Método reset que permite colocar o valor por omissão no Fogao,
     * neste caso desligado.
     */
    public void reset(){
        super.energyOn = false;
    }
    /**
     * Método que permite fazer a leitura do Fogao ao qual este Detetor 
     * está associado
     * Garanta que:
     * O Detetor esteja associado a um Fogao
     * O Fogao esteja num Compartimento
     * O Fogao e o Detetor pertençam ao mesmo Compartimento
     */
    @Override
    public void read(){
        if(fogao == null){
            System.out.println("Nao existe Fogão");
            return;
        }
        if(fogao.getCompartimento() == null){
            System.out.println("Deve associas o fogão a um compartimento");
            return;
        }
        if(fogao.getCompartimento().equals(this.getCompartimento())){
            if(fogao.isEnergyOn()) {
                System.out.println("fogão ligado");
                this.setEnergyOn();
                return;
            }else {
                System.out.println("fogão desligado");
                this.setEnergyOff();
                return;
            }
        }else{
            System.out.println("O fogão associado encontra-se noutro compartimento");
            return;
        }
    }
    /**
     * Método toString da descrição do DetetorDeEnergia
     * 
     * @return String - Descrição completa do DetetorDeEnergia
     */
    @Override
    public String toString(){
        String str = "";
        str += "Detetor de Energia \n ID: "+getId();
        str += "\nAssociado ao Fogão: ";
        if(fogao != null){
            str+=this.fogao.getId();
        }
        if(super.isEnergyOn()){
            str += "\nFogão ligado\n\n";
        }else{
            str += "\nFogão desligado\n\n";
        }
        return str;
    }
}