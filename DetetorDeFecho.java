/**
 * Esta classe permite criar um Equipamento especifico, um Detetor de Fecho.
 * Este Equipamento vai fazer a leitura de um Trinco e verificar se este está aberto ou fechado
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class DetetorDeFecho extends Fecho implements Sensor
{
    private TrincoEletrico trinco;
    /**
     * Construtor da classe DetetorDeFecho, vai instanciar um Equipamento - DetetorDeFecho,
     * com os atributos da classe Fecho.
     */
    public DetetorDeFecho(){
        super();
    }
    /**
     * Método que permite associar este Detetor a um Trinco.
     * Garanta que cada Detetor só tenha 1 Trinco
     * 
     * @param trinco - TrincoEletrico a ser associado a este DetetorDeFecho
     */
    public void setTrinco(TrincoEletrico trinco) {
        this.trinco = trinco;
    }

    /**
     * Metodo que devolve o trico eletrico associado a este detetor de fecho
     *
     */
    public TrincoEletrico getTrinco(){
        return trinco;
    }
    /**
     * Método reset que permite colocar o valor por omissão no Trinco,
     * neste caso aberto.
     */

    public void reset(){
        super.open = true;
    }
    /**
     * Método que permite fazer a leitura do TrincoEletrico ao qual este Detetor 
     * está associado
     * Garanta que:
     * O Detetor esteja associado a um Trinco
     * O Trinco esteja num Compartimento
     * O Trinco e o Detetor pertençam ao mesmo Compartimento
     */
    @Override
    public void read(){
        if(trinco == null){
            System.out.println("Nao existe porta");
            return;
        }
        if(trinco.getCompartimento() == null){
            System.out.println("Deve associar o trinco a um compartimento");
            return;
        }
        if(trinco.getCompartimento().equals(this.getCompartimento())){
            if(trinco.isOpen()) {
                System.out.println("Porta aberta");
                this.setOpen();
                return;
            }else {
                System.out.println("Porta fechada");
                this.setClose();
                return;
            }
        }else{
            System.out.println("O trinco associado encontra-se noutro compartimento");
            return;
        }
    }
    /**
     * Método toString da descrição do DetetorDeFecho
     * 
     * @return String - Descrição completa do DetetorDeFecho
     */
    @Override
    public String toString(){
        String str = "";
        str += "Detetor de Fecho \n ID: "+getId();
        if(trinco != null){
        str += "\nAssociado ao Trinco: "+this.trinco.getId();

        if(trinco.isOpen()){
            str += "\nPorta Aberta\n\n";
        }else{
            str += "\nPorta Fechada \n\n";
        }}else{
            str+= "Nenhum trinco associado";
        }
        return str;
    }
}