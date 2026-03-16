/**
 * Esta classe permite criar um Equipamento especifico, uma Torneira.
 * Este Equipamento vai permitir abrir e fechar a torneira, atualizando o estado
 * da mesma simulteneamente.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 21/05/2024
 */
public class Torneira extends Agua implements Atuador
{
    /**
     * Construtor da classe Torneira, vai instanciar um Equipamento - Torneira,
     * com os atributos da classe Agua.
     */
    public Torneira(){
        super();
    }
    /**
     * Método que permite fazer reset à água do Compartimento,
     * deixando-o com a água fechada, ou seja, fechando as torneiras.
     */
    @Override
    public void reset(){
        super.watter = false;
    }
    /**
     * Método que permite abrir ou fechar a Torneira.
     * Caso a água esteja aberta, ele irá fechar a torneira, fechando a água.
     * Caso a água esteja fechada, ele vai abrir a torneira, abrindo a água.
     */
    @Override
    public void act(){
        if(super.isWatterOpen()){
            super.setWatterClose();
        }else{
            super.setWatterOpen();
        }
    }
    /**
     * Método toString da descrição da Torneira.
     * 
     * @return String - Descrição completa da Torneira
     */
    @Override
    public String toString(){
        String str = "";
        str += "Torneira \n ID: "+getId();
        if(isWatterOpen()){
            str += "\n Torneira Aberta\n";
        }else{
            str += "\n Torneira Fechada\n";
        }
        return str;
    }
}
