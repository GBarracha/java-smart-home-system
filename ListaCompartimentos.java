import java.util.ArrayList;

/**
 * Escreva uma descrição da classe ListaEquipamentos aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
class ListaCompartimentos extends ArrayList<Compartimento> {
    private static ListaCompartimentos lista;

    private ListaCompartimentos() {}

    public static ListaCompartimentos getLista() {
        if (lista == null) {
            lista = new ListaCompartimentos();
        }
        return lista;
    }
    public void adicionarCompartimento(Compartimento compartimento) {
        this.add(compartimento);
    }
}