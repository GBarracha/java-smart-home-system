import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Esta classe permite editar o Compartimento selecionado, neste caso o que é recebido por parâmetro
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 29/06/2024
 */
public class CompartimentoEdition extends VBox {

    /**
     * Construtor da classe CompartimentoEdition, recebe um Compartimento por parâmetro que vai permitir editar o mesmo
     * Esta VBox possui 5 botões uteis, o "Criar" que vai permitir criar um Equipamento à escolha do utilizador, o "Apagar"
     * que permite apagar o Equipamento selecionado pelo utilizador, o "Associar" que vai permitir associar um sensor a um atuador,
     * o "Aceitar" que permite realizar a ação e guardar os dados, e o "Cancelar" que vai permitir interromper a ação e voltar atrás
     *
     * @param compartimento - Compartimento a ser editado
     */
    public CompartimentoEdition(final Compartimento compartimento) {
        Label listLabel = new Label("Compartimento:");
        Label tf = new Label(compartimento.getDesignacao());
        tf.setPrefWidth(200);
        tf.setStyle("-fx-border-color: grey; -fx-padding: 1;");
        Label listLabelE = new Label("Equipamentos:");
        final ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(compartimento.getAllEquipamentos());
        final ListView<Equipamento> list = new ListView<>(equipamentos);
        VBox vbox = new VBox(10);
        HBox hbox = new HBox(10, listLabel,tf);

        HBox buttonsPanel = new HBox(10);

        // Botão criar
        Button createButton = new Button("Criar");
        createButton.setOnAction(e -> listLabel.getScene().setRoot(new EquipmentCreator(compartimento)));

        // Botão Apagar
        Button deleteButton = new Button("Apagar");
        deleteButton.setOnAction(e -> {
            Equipamento equipamento = list.getSelectionModel().getSelectedItem();
            new Confirmation("Apagar Equipamento", "Quer mesmo apagar o equipamento?", e2 -> {
                if (equipamento != null) {
                    compartimento.getAllEquipamentos().remove(equipamento);
                    list.getScene().setRoot(new CompartimentoEdition(compartimento));
                }
            });
        });

        // Botão associar
        Button associateButton = new Button("Associar");
        associateButton.setOnAction(e -> {
            Equipamento equipamento = list.getSelectionModel().getSelectedItem();
            if (equipamento instanceof TrincoEletrico || equipamento instanceof EstoreEletrico || equipamento instanceof Fogao) {
                list.getScene().setRoot(new AssociateMenu(compartimento,equipamento));
            } else {
                new Warning("Associar Equipamento", "Tem de indicar um equipamento que seja um atuador com sensor local");
            }
        });
        buttonsPanel.getChildren().addAll(createButton, deleteButton, associateButton);

        Button btnA = new Button("Aceitar");
        btnA.setOnAction(e -> list.getScene().setRoot(new CompartimentoViewer(compartimento.getConsola())));

        Button btnB = new Button("Cancelar");
        btnB.setOnAction(e -> list.getScene().setRoot(new CompartimentoViewer(compartimento.getConsola())));

        // HBox para os botões Aceitar e Cancelar
        HBox hbox2 = new HBox(10, btnA, btnB);
        hbox2.setAlignment(Pos.CENTER); // Centraliza os botões

        vbox.getChildren().addAll(list, buttonsPanel);

        // Posicionar os nós
        setPadding(new Insets(10));
        setSpacing(10);
        getChildren().addAll(hbox,listLabelE, vbox, hbox2);
    }
}
