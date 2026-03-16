import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Esta classe permite criar Equipamentos através de uma interface bastante simples e otimizada, recebendo
 * apenas um Compartimento por parâmetro, o mesmo onde o Equipamento vai ser colocado
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 29/06/2024
 */
public class EquipmentCreator extends VBox {

    /**
     * Construtor da classe EquipmentCreator, recebe um Compartimento por parâmetro onde vai permitir criar
     * um Equipamento no mesmo.
     * Esta VBox possui uma lista com todos os Equipamentos disponíveis que podem ser criados,
     * depois de selecionado o Equipamento tem 1 botão "Criar" que permite criar o Equipamento, e tem o botão
     * "Cnacelar" que permite interromper a operação e voltar atrás
     *
     * @param compartimento - Compartimento onde quer criar o Equipamento
     */
    public EquipmentCreator(final Compartimento compartimento){

    Label label = new Label("Escolha o tipo de equipamento a criar");
    final ObservableList<String> tipos = FXCollections.observableArrayList("Ar Condicionado","Detetor de Agua","Detetor de Energia","Detetor De Fecho","Detetor De Luz","Detetor De Posicao","Estore Eletrico","Fogao","Interruptor de Lampada","Termometro","Torneira","Trinco Eletrico");
    final ListView<String> list = new ListView<>(tipos);
    //Botao criar equipamento
    Button createButton = new Button("Criar");
    createButton.setOnAction(e -> {
        String selectedType = list.getSelectionModel().getSelectedItem();
        if (selectedType != null) {
            Equipamento equipamento = null;
            switch (selectedType) {
                case "Ar Condicionado":
                    equipamento = new ArCondicionado();
                    break;
                case "Detetor de Agua":
                    equipamento = new DetetorDeAgua();
                    break;
                case "Detetor de Energia":
                    equipamento = new DetetorDeEnergia();
                    break;
                case "Detetor De Fecho":
                    equipamento = new DetetorDeFecho();
                    break;
                case "Detetor De Luz":
                    equipamento = new DetetorDeLuz();
                    break;
                case "Detetor De Posicao":
                    equipamento = new DetetorDePosicao();
                    break;
                case "Estore Eletrico":
                    equipamento = new EstoreEletrico();
                    break;
                case "Fogao":
                    equipamento = new Fogao();
                    break;
                case "Interruptor de Lampada":
                    equipamento = new InterruptorDeLampada();
                    break;
                case "Termometro":
                    equipamento = new Termometro();
                    break;
                case "Torneira":
                    equipamento  = new Torneira();
                    break;
                case "Trinco Eletrico":
                    equipamento = new TrincoEletrico();
                    break;
                }
                compartimento.addEquipamento(equipamento);
                list.getScene().setRoot(new CompartimentoEdition(compartimento));

            }
        });
    Button cancelButton = new Button("Cancelar");
    cancelButton.setOnAction(e -> list.getScene().setRoot(new CompartimentoViewer(compartimento.getConsola())));
    HBox buttonGroup = new HBox(10,createButton,cancelButton);
    setPadding(new Insets(10));
    getChildren().addAll(label, list,buttonGroup);
    setSpacing(10);
    }
}
