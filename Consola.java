import java.util.Set;
import java.util.TreeSet;
import java.io.*;
import java.util.Collections;
import java.net.URL;
import java.net.URISyntaxException;

/**
 * A classe Consola serve para gerir um conjunto de compartimentos, ou anexos de uma casa, permitindo criar ou adicionar compartimentos nesta consola.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */
public class Consola implements Serializable
{
    protected Set<Compartimento> compartimentos;
    private String consoleName;
    ListaCompartimentos lista = ListaCompartimentos.getLista();
    /**
     * Construtor da classe Consola que instancia uma Consola e um TreeSet de Compartimentos.
     * 
     * @param consoleName - Nome da Consola a ser criada
     */
    public Consola(String consoleName){
        this.compartimentos = new TreeSet<>();
        this.consoleName = consoleName;
    }
    /**
     * Método que cria um Compartimento, associando-o e adicionando-o a esta Consola.
     * 
     * @param compartimento - Nome do Compartimento
     */
    public void addCompartimento(Compartimento compartimento) {
        if (compartimento.getDesignacao().isEmpty()) {
            throw new IllegalArgumentException("Designação não pode ser nula");
        }
        for (Compartimento c : this.compartimentos) {
            if (c.getDesignacao().equals(compartimento.getDesignacao())) {
                throw new IllegalArgumentException("Designação já existente");
            }
        }
        compartimento.associateCompartimentoToConsola(this);
        compartimentos.add(compartimento);
        System.out.println("Compartimento " + compartimento.getDesignacao() + " adicionado com sucesso à consola " + this.consoleName);

    }
    /**
     * Método que devolve todos os Compartimentos existentes nesta Consola.
     * 
     * @return TreeSet<Compartimento> - Compartimentos existentes nesta Consola  
     */
    public Set<Compartimento> getCompartimentos(){
        return this.compartimentos;
    }
    /**
     * Método que altera o nome de um Compartimento existente na Consola.
     * Se o nome do Compartimento não existir nesta Consola não será possível alterá-lo.
     * 
     * @param designacao - Nome do Compartimento atual
     * @param novaDesignacao - Novo nome a ser atualizado
     */
    public void mudarNomeCompartimento(String designacao, String novaDesignacao){
        for(Compartimento cp : lista){
            if(cp.getDesignacao().equals(designacao)){
                if(!cp.getDesignacao().equals(novaDesignacao)){
                    cp.setDesignacao(novaDesignacao);
                    System.out.println("Compartimento: "+novaDesignacao);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Não é possível alterar o nome.");
    }
    /**
     * Método que faz reset a todos os Equipamentos de todos os Compartimentos nesta Consola, colocando-os com os valores por omissão
     */
    public void reset(){
        System.out.println("Reset à consola realizado com sucesso!");
        for(Compartimento c : compartimentos){
            for(Equipamento e : c.getAllEquipamentos()){
                e.reset();
            }
        }
    }
    /**
     * Método que lê e carrega os dados de uma Consola
     * 
     * @param ficheiro - Nome do ficheiro que queremos ler e carregar na Consola
     */
    public static Consola readConsola(String ficheiro){
        Consola c1;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ficheiro))) {
            c1 = (Consola) inputStream.readObject();
            inputStream.close();
            System.out.println("Dados carregados para o ficheiro: " + ficheiro);
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            c1 = new Consola(ficheiro);
        }
        return c1;
    }
    /**
     * Método que escreve os dados de uma consola dentro de um ficheiro
     * 
     * @param ficheiro - Nome do ficheiro onde queremos escrever os dados da Consola
     */
    public void writeConsola(String ficheiro){
        File f1 = new File(ficheiro);
        f1.delete();
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(ficheiro))) {
            stream.writeObject(this);
            stream.close();
            System.out.println("Dados gravados para o ficheiro: " + ficheiro);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Método toString da descrição da Consola.
     * 
     * @return String - Descrição completa da Consola
     */
    @Override
    public String toString(){
        String cps = "";
        for(Compartimento cp: compartimentos){
            cps += "\n"+cp.toString();
        }
        if(cps.equals("")){
            return "Não existem compartimentos associados a esta consola";
        }else{
            return cps;   
        }
    }
}