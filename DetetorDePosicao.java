/**
 * Esta classe permite criar um Equipamento especifico, um Detetor de Posição.
 * Este Equipamento vai fazer a leitura de um Estore e verificar a posição do mesmo
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class DetetorDePosicao extends Posicao implements Sensor
{
    private EstoreEletrico estore;
    /**
     * Construtor da classe DetetorDePosicao, vai instanciar um Equipamento - DetetorDePosicao,
     * com os atributos da classe Posicao.
     */
    public DetetorDePosicao()
    {
        super();
    }
    /**
     * Método que permite associar este Detetor a um Estore.
     * Garanta que cada Detetor só tenha 1 Estore
     * 
     * @param estore - EstorEletrico a ser associado a este DetetorDePosicao
     */
    public void setEstore(EstoreEletrico estore){

        this.estore = estore;
    }

    /**
     * Metodo que retorna o estore ao qual este detetor está associado
     *
     */
    public EstoreEletrico getEstore(){
        return estore;
    }
    /**
     * Método reset que permite colocar o valor por omissão no Estore,
     * neste caso aberto.
     */
    @Override
    public void reset(){
        super.setPositionFromList(ListaPosicoes.OPEN);
    }
    /**
     * Método que permite fazer a leitura do EstoreEletrico ao qual este Detetor 
     * está associado
     * Garanta que:
     * O Detetor esteja associado a um Estore
     * O Estore esteja num Compartimento
     * O Estore e o Detetor pertençam ao mesmo Compartimento
     */
    public void read(){
        if(estore == null){
            System.out.println("Nao existe Estore");
            return;
        }
        if(estore.getCompartimento() == null){
            System.out.println("Deve associar o estore a um compartimento");
            return;
        }
        if(estore.getCompartimento().equals(this.getCompartimento())){
            switch(estore.getPosition()){
            case 1:
                super.setPositionFromList(ListaPosicoes.OPEN);
                System.out.println("O estore encontra-se aberto");
                break;
            case 2:
                super.setPositionFromList(ListaPosicoes.TWO_THIRDS);
                System.out.println("O estore encontra-se dois terços aberto");
                break;
            case 3:
                super.setPositionFromList(ListaPosicoes.HALF_OPEN);
                System.out.println("O estore encontra-se metade aberto");
                break;
            case 4:
                super.setPositionFromList(ListaPosicoes.ONE_THIRD);
                System.out.println("O estore encontra-se um terço aberto");
                break;
            case 5:
                super.setPositionFromList(ListaPosicoes.CLOSE);
                System.out.println("O estore encontra-se fechado");
                break;
            }
        }
        else{
            System.out.println("O estore associado encontra-se noutro compartimento");
            return;
        }
    }
    /**
     * Método toString da descrição do DetetorDePosicao
     * 
     * @return String - Descrição completa do DetetorDePosicao
     */
    @Override
    public String toString(){
        String str = "";
        str += "Detetor de Posicao \nID: "+getId();
        if(estore!= null) {
            str += "\nAssociado ao Estore: " + this.estore.getId();
        }else{
            str += "\nNao existe Estore associado";
        }
        str += "\nPosicao: "+super.getPositionFromList()+"\n\n";
        return str;
    }
}