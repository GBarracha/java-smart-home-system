import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import javafx.scene.Scene;

/**
 * Esta classe permite criar uma Confirmação
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class Confirmation extends Stage {
    /**
     * Construtor da classe Confirmation, recebe um titulo, uma mesnagem e uma ação.
     * Esta stage permite lançar uma HBox com uma confirmação se pretende realizar a ação.
     *
     * @param title - Titulo da HBox
     * @param message - Mensagem a ser atribuida
     * @param yesAction - Ação a ser realizada
     */
    public Confirmation(String title,
                        String message,
                        final EventHandler<ActionEvent> yesAction) {
        //Criar o painel com a informação
        VBox mainPanel = new VBox(10);
        mainPanel.setPadding(new Insets(10));
        mainPanel.setAlignment(Pos.CENTER);
        //Criar a mensagem:
        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-weight: bold;");
        //Criar botões:
        final HBox buttonsPanel = new HBox(10);
        buttonsPanel.setAlignment(Pos.CENTER);
        Button yesButton = new Button("Sim");
        yesButton.setOnAction(e -> {
            yesAction.handle(e);
            ((Stage)buttonsPanel.getScene().getWindow()).close();
        });
        Button noButton = new Button("Não");
        noButton.setOnAction(e -> ((Stage) buttonsPanel
                .getScene().getWindow()
        ).close());
        buttonsPanel.getChildren().addAll(yesButton, noButton);

        //Posicionar os nós:
        mainPanel.getChildren()
                .addAll(messageLabel, buttonsPanel);

        setResizable(false);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setIconified(false);
        centerOnScreen();
        setTitle(title);
        setScene(new Scene(mainPanel));
        show();
    }
}