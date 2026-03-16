import java.io.*;
/**
 * Esta classe abstrata permite definir vários métodos (concretos e abstratos)
 * que serão utilizados por todos os Equipamentos deste Sistema.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso 
 * @version 17/05/2024
 */
public abstract class Equipamento implements Comparable<Equipamento>,Serializable
{ 
    private final int id;
    private static int numberOfEquipments = 0;
    static {
        // Read the last number of equipments from a file
        try (BufferedReader reader = new BufferedReader(new FileReader("equipmentCount.txt"))) {
            numberOfEquipments = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            numberOfEquipments = 0; // Default to 0 if file not found or invalid format
        }
    }
    private Tipo tipoEquipamento;
    private Compartimento compartimento;
    private boolean associated;
    /**
     * Construtor da classe abstrata Equipamento que permite definir o id de todos
     * os Equipamentos criados
     */
    public Equipamento(){
        this.id = ++numberOfEquipments;
        this.compartimento=null;
        this.associated = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipmentCount.txt"))) {
            writer.write(Integer.toString(numberOfEquipments));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que devolve o id do Equipamento
     * 
     * @return Integer - Id do Equipamento
     */
    public int getId(){
        return this.id;
    }

    /**
     * Método que devolve o Compartimento onde o Equipamento está instalado
     * 
     * @return Compartimento - Compartimento onde o Equipamento se encontra
     */
    public Compartimento getCompartimento(){
        return this.compartimento;
    }
    /**
     * Método que permite alterar o Equipamento para outro Compartimento
     * 
     * @param compartimento - Compartimento para onde queremos mudar o Equipamento
     */
    // rever este método para alterar os equipamentos de compartimento e fazer verificações
    public void setCompartimento(Compartimento compartimento){
        this.compartimento = compartimento;
        associated = true;
    }
    public void changeCompartimento(Compartimento compartimento){
        this.compartimento.getAllEquipamentos().remove(this);
        Compartimento c1 = this.compartimento;
        this.compartimento = compartimento;
        compartimento.getAllEquipamentos().add(this);
        
        System.out.println("Equipamento : " + this.id + " mudado do compartimento " + c1.getDesignacao() + " para " + compartimento.getDesignacao());
    }
    /**
     * Método que devolve o Tipo do Equipamento.
     * 
     * return Tipo - Tipo de Equipamento
     */
    public Tipo getTipo(){
        return this.tipoEquipamento;
    }
    /**
     * Método que permite alterar o Tipo de Equipamento
     * 
     * @param tipo - Tipo de Equipamento a atribuir ao mesmo
     */
    public void setTipo(Tipo tipo){

        this.tipoEquipamento= tipo;
    }
    public boolean isAssociated(){
        if(compartimento != null){
            return true;
        }
        return false;
    }
    /**
     * Método abstrato que será implementado em cada Equipamento
     */
    public abstract void reset();
    /**
     * Método que faz a comparação dos Equipamentos
     * 
     * @param equipamento - Equipamento a ser comparado
     * @return Integer - valor da comparação
     */
    @Override
    public int compareTo(Equipamento equipamento){
        return this.getId()-equipamento.getId();
    }
    /**
     * Método toString do Tipo de Equipamento.
     * 
     * @return String - Tipo de Equipamento
     */
    @Override
    public String toString(){
        return tipoEquipamento.name();
    }
}