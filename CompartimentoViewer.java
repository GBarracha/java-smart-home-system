import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Esta classe permite visualizar uma ObservableList de Compartimentos numa dada Consola
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 29/06/2024
 */
public class CompartimentoViewer extends StackPane {
    /**
     * Construtor da classe CompartimentoViewer, recebe uma Consola para visualizar os seus Compartimentos
     * Este StackPane possui uma observableList de Compartimentos e 5 botões uteis, o "Criar" que permite
     * criar um novo Compartimento, o "Editar" que permite Editar o Compartimento selecionado, o "Apagar"
     * que permite apagar o Compartimen to selecionado, o "Monitiorizar" que permite visualizar de uma forma
     * mais detalhada, todos os equipamentos que o Compartimento selecionado possui, e o "Reset" que permite
     * reeiniciar a Consola e colocar todos os Equipamentos de todos os Compartimentos daquela consola com
     * valor por defeito.
     *
     * @param consola - Consola que pretende analisar
     */
    public CompartimentoViewer(final Consola consola) {
        VBox vbox = new VBox();
        Label listLabel = new Label("Compartimentos:");
        final ObservableList<Compartimento> compartimentos = FXCollections.observableArrayList(consola.getCompartimentos());
        final ListView<Compartimento> list = new ListView<>(compartimentos);

        // HBox para os botões
        HBox buttonsPanel = new HBox(10);
        buttonsPanel.setAlignment(Pos.CENTER); // Centraliza os botões
        buttonsPanel.setPadding(new Insets(10));

        // Botão criar
        Button createButton = new Button("Criar");
        createButton.setOnAction(e -> list.getScene().setRoot(new CompartimentoCreator(consola)));

        // Botão editar
        Button editButton = new Button("Editar");
        editButton.setOnAction(e -> {
            Compartimento compartimento = list.getSelectionModel().getSelectedItem();
            if (compartimento != null) {
                list.getScene().setRoot(new CompartimentoEdition(compartimento));
            }
        });

        // Botão apagar
        Button deleteButton = new Button("Apagar");
        deleteButton.setOnAction(e -> {
            Compartimento compartimento = list.getSelectionModel().getSelectedItem();
            new Confirmation("Monitor Compartimento", "Quer mesmo apagar o compartimento?", e2 -> {
                if (compartimento != null) {
                    consola.getCompartimentos().remove(compartimento);
                    list.getScene().setRoot(new CompartimentoViewer(consola));
                }
            });
        });

        // Botão monitorizar
        Button monitButton = new Button("Monitorizar");
        monitButton.setOnAction(e -> {
            Compartimento compartimento = list.getSelectionModel().getSelectedItem();
            if(compartimento != null) {
            list.getScene().setRoot(new MonitorMenu(compartimento));
            }
        });

        // Botão reset
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> new Confirmation("Reset", "Quer mesmo fazer o Reset da consola?", e2 -> consola.reset()));

        buttonsPanel.getChildren().addAll(createButton, editButton, deleteButton, monitButton, resetButton);

        // Posicionar os nós
        setPadding(new Insets(10));
        vbox.getChildren().addAll(listLabel, list, buttonsPanel);
        vbox.setSpacing(10);
        getChildren().setAll(vbox);
    }
}
