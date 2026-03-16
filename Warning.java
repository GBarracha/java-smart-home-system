import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import javafx.scene.Scene;

/**
 * Esta classe permite lançar uma Warning.
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class Warning extends Stage {
    /**
     * Construtor da classe Warning, recebe com parâmetro um titulo e uma mensagem a ser exibida
     *
     * @param title - Titulo do Aviso
     * @param message - Mensagem a ser lançada
     */
    public Warning(String title, String message) {

        // Criar o painel com a informação
        VBox mainPanel = new VBox(10);
        mainPanel.setPadding(new Insets(10));
        mainPanel.setAlignment(Pos.CENTER);

        // Criar a mensagem
        Label shownMessage = new Label(message);
        shownMessage.setStyle("-fx-font-weight: bold;");

        // Criar botão
        final Button okButton = new Button("OK");
        okButton.setOnAction(e -> ((Stage) okButton.getScene().getWindow()).close());

        // Posicionar os nós
        mainPanel.getChildren().addAll(shownMessage, okButton);
        setResizable(false);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setIconified(false);
        centerOnScreen();
        setTitle(title);
        setScene(new Scene(mainPanel));
        showAndWait(); // Use showAndWait para bloquear a janela até que o usuário interaja com ela
    }
}
