import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.io.*;

/**
 * A classe compartimento permite criar compartimentos de uma casa, dentro de cada compartimento é possível adicionar equipamentos e gerir os mesmos.
 * Não é possível ter compartimentos com igual designação na mesma casa.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class Compartimento implements Comparable<Compartimento>,Serializable {
    public String designacao;
    private Set<Equipamento> equipamentos;
    private Consola consola;
    private boolean associate;
    /**
     * Construtor da classe Compartimento, vai instanciar um compartimento com a designação passada por parâmetro.
     * Se a designação for nula ou se já existir algum compartimento na mesma casa com o mesmo nome, será lançada uma excessão.
     * 
     * @param designacao - Nome do Compartimento a ser criado
     */
    public Compartimento(String designacao) 
    {
        setDesignacao(designacao);
        this.equipamentos = new TreeSet<>();
        this.associate = false;
        ListaCompartimentos.getLista().adicionarCompartimento(this);
    }
    /**
     * Método que associa este compartimento a uma consola.
     * Se este compartimento já pertencer à consola passada por parâmetro, não será possível associá-la novamente.
     * 
     * @param consola - Consola onde quer associar este compartimento
     */
    public void associateCompartimentoToConsola(Consola consola){
        this.consola = consola;
    }
    /**
     * Método de retorno que devolve se este compartimento já está associado a alguma consola
     * 
     * @return Boolean - Valor true ou false se estiver associado
     */
    public boolean isAssociate(){
        return this.associate;
    }
    /**
     * Método de retorno que devolve a Designação deste compartimento.
     * 
     * @return String - Nome do Compartimento
     */
    public String getDesignacao(){
        return designacao;
    }
    /**
     * Método que altera a Designação do Compartimento
     * 
     * @param designacao - Nome do Compartimento
     */
    public void setDesignacao(String designacao){
        this.designacao = designacao;
    }
    /**
     * Método que adiciona um Equipamento a este Compartimento.
     * Se o equipamento já existir neste Compartimento não será possível adicioná-lo novamente.
     * 
     * @param equipamento - Equipamento a ser adicionado a este compartimento
     */
    public void addEquipamento(Equipamento equipamento){
        if(equipamento != null){
            if(equipamentos.contains(equipamento)){
                System.out.println("Este equipamento já existe neste compartimento");
                return;  
            }else if(equipamento.isAssociated() == true){
                System.out.println("Este equipamento está associado a um compartimento distinta");
                return;
            }else{
                equipamento.setCompartimento(this);
                equipamentos.add(equipamento);
                System.out.println("Equipamento "+equipamento.getId()+" adicionado com sucesso ao compartimento "+this.designacao);
                return;
            }
        }else{
            System.out.println("Insira um equipamento válido");
            return;
        }
    }
    /**
     * Método que devolve todos os Equipamentos existentes neste Compartimento.
     * 
     * @return TreeSet<Equipamento> - Equipamento pertencentes a este Compartimento  
     */
    public Set<Equipamento> getAllEquipamentos(){
        return equipamentos;   
    }
    /**
     * Método que devolve a Consola que gere este Compartimento
     * 
     * @return Consola - Consola à qual este Compartimento está associado  
     */
    public Consola getConsola(){
        return consola;
    }
    /**
     * Método que faz a comparação das designações que denominam os Compartimentos.
     * 
     * @param compartimento - Compartimento a ser comparado
     * @return Integer - valor da comparação
     */
    @Override
    public int compareTo(Compartimento compartimento){
        if(this.designacao == null){
             return 1;
        }
        return this.designacao.compareToIgnoreCase(compartimento.designacao);
    }
    /**
     * Método toString da descrição do Compartimento.
     * 
     * @return String - Descrição completa do Compartimento
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Compartimento: ").append(designacao).append("\n");

                
        return builder.toString();
    }
}
    

