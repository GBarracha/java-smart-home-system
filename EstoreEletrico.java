/**
 * Esta classe permite criar um Equipamento especifico, um Estore Elétrico.
 * Este Equipamento vai permitir abrir e fechar o estore, atualizando o estado
 * pretendido pelo utilizador, tendo este a possibilidade de ter várias posições.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class EstoreEletrico extends Posicao implements Atuador
{
    private int position;
    private DetetorDePosicao detetorDePosicao;
    /**
     * Construtor da classe EstoreEletrico, vai instanciar um Equipamento - EstoreEletrico,
     * com os atributos da classe Posicao.
     */
    public EstoreEletrico()
    {
        super();
        this.position = 1;
    }
    /**
     * Método que permite alterar a posição do Estore
     * de acordo com os seguintes valores:
     *  1 - Aberto
     *  2 - Dois terços
     *  3 - Meio aberto
     *  4 - Um terço
     *  5 - Fechado
     *  
     * @param posicao - Valor de 1-5 que altera a posição do Estore
     */
    public void setPosition(int posicao){
        this.position = posicao;
    }
    /**
     * Método que devolve o valor da posição  atual
     * 
     * @return Integer - Valor da posição atual
     */
    public int getPosition(){
        return this.position;
    }

    /**
     *Metodo que permite definir um detetor de posição ao qual o estore irá associar
     */
    public void setDetetorDePosicao(DetetorDePosicao det){
        this.detetorDePosicao = det;
    }

    /**
     * Metodo que retorna o Detetor de Posicao que o estore está associado
     * @return
     */
    public DetetorDePosicao getDetetorDePosicao(){
        return this.detetorDePosicao;
    }
    /**
     * Método que permite fazer reset ao EstoreEletrico de um Compartimento,
     * colocando o EstoreEletrico por omissão como aberto
     */

    @Override
    public void reset(){
        setPosition(1);
        super.setPositionFromList(ListaPosicoes.OPEN);
    }
    /**
     * Método que permite atualizar a posição do Estore.
     * Primeiramente deve fazer uso do método setPosition()
     * para colocar a posição pretendida
     */
    @Override
    public void act(){
        switch(getPosition()){
            case 1:
                super.setPositionFromList(ListaPosicoes.OPEN);
                break;
            case 2:
                super.setPositionFromList(ListaPosicoes.TWO_THIRDS);
                break;
            case 3:
                super.setPositionFromList(ListaPosicoes.HALF_OPEN);
                break;
            case 4:
                super.setPositionFromList(ListaPosicoes.ONE_THIRD);
                break;
            case 5:
                super.setPositionFromList(ListaPosicoes.CLOSE);
                break;
        }
    }
    /**
     * Método toString da descrição do EstoreEletrico
     * 
     * @return String - Descrição completa do EstoreEletrico
     */
    @Override
    public String toString(){
        String str = "";
        str += "Estore Eletrico \nID: "+getId();
        str += "\nPosicao: "+super.getPositionFromList()+"\n";
        return str;
    }
}