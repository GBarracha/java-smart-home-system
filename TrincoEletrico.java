import java.io.Serializable;

/**
 * Esta classe permite criar um Equipamento especifico, um Trinco Elétrico.
 * Este Equipamento vai permitir abrir e fechar o trinco, atualizando o estado
 * de aberto para fechado simultaneamente.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class TrincoEletrico extends Fecho implements Atuador{
    private DetetorDeFecho detetorDeFecho;
    /**
     * Construtor da classe TrincoEletrico, vai instanciar um Equipamento - TrincoEletrico,
     * com os atributos da classe Fecho.
     */
    public TrincoEletrico(){
        super();
    }
    /**
     * Metodo que devolve o detetor de fecho associado a este trinco
     */
    public DetetorDeFecho getDetetorDeFecho(){
        return detetorDeFecho;
    }

    /**
     * Método que permite definir qual  detetor de fecho ira estar associado a este trinco
     */
    public void setDetetorDeFecho(DetetorDeFecho d){
        detetorDeFecho = d;
    }
    /**
     * Método que permite fazer reset ao TrincoEletrico de um Compartimento,
     * colocando o TrincoEletrico por omissão como aberto
     */
    @Override
    public void reset(){
        super.open = true;
    }

    /**
     * Método que permite abrir e fechar o TrincoEletrico.
     * Caso esteja aberto, ele altera o valor e fecha o trinco.
     * Caso esteja fechado, ele altera o valor e abre o trinco.
     */
    @Override
    public void act(){
        if(super.isOpen()){
            super.setClose();
        }else{
            super.setOpen();
        }
    }
    /**
     * Método toString da descrição do TrincoEletrico
     * 
     * @return String - Descrição completa do TrincoEletrico
     */
    @Override
    public String toString(){
        String str = "";
        str += "Trinco Elétrico \n ID: "+getId();
        if(super.isOpen()){
            str += "\n Trinco Aberto \n";
        }else{
            str += "\n Trinco Fechado \n";
        }
        return str;
    }
}