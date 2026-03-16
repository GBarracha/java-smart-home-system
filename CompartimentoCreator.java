import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Esta classe permite criar Compartimentos através de uma interface acessível e simples,
 * apenas é necessário digitar o nome do Compartimento pretendido a ser criado, e caso este não seja
 * repetido, o mesmo é criado
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 29/06/2024
 */
public class CompartimentoCreator extends VBox {
    /**
     * Construtor da classe CompartimentoCreator, recebe uma consola como parâmetro que vai permitir
     * criar o compartimento na mesma.
     * Esta VBox vai ter uma fieldText para o utilizador escrever o compartimento, e 2 botões utéis,
     * o "Aceitar" que vai permitir realizar a ação e criar o compartimento, e o "Cancelar" que vai
     * interromper a ação e voltar atrás.
     *
     * @param consola - Consola pretendida para a criação do Compartimento
     */
    public CompartimentoCreator(final Consola consola) {

        Label lbl = new Label("Compartimento:");
        final TextField tf = new TextField();
        tf.setPrefWidth(200);
        BorderPane bp = new BorderPane();

        Button btnA = new Button("Aceitar");
        btnA.setOnAction(e -> {
            try {
                Compartimento c1 = new Compartimento(tf.getText());
                consola.addCompartimento(c1);
                Stage stage = (Stage) tf.getScene().getWindow();
                stage.getScene().setRoot(new CompartimentoEdition(c1));
            } catch (IllegalArgumentException ex) {
                new Warning("Designação Compartimento", ex.getMessage());
            }
        });

        Button btnC = new Button("Cancelar");
        btnC.setOnAction(e -> tf.getScene().setRoot(new CompartimentoViewer(consola)));

        HBox hbox = new HBox(10, lbl, tf);
        HBox hbox2 = new HBox(10, btnA, btnC);
        bp.setCenter(hbox2);

        this.getChildren().addAll(hbox, bp);
        setSpacing(10);
        setPadding(new Insets(10));
    }
}