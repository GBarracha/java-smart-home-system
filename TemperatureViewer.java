import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.text.NumberFormat;

/**
 * Esta classe permite visualizar a temperatura pretendida pelo utilizador.
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class TemperatureViewer extends VBox {
    private final TemperatureSlider temperatureSlider;
    private final TextField temperatureField;

    /**
     * Construtor da classe Temperature Viewer, esta VBox possui uma testField onde o valor da temperatura
     * vai sendo apresentado ao momento, e um slider onde é possivel  manipular os valores.
     * Posuui também 2 botões uteis, o "Ok" que permite realizar a ação, e o "Cnacelar" que interrompe
     * a mesma e volta atrás
     *
     * @param equipamento - ArCondicionado a ser manipulado
     */
    public TemperatureViewer(final ArCondicionado equipamento) {
        temperatureSlider = new TemperatureSlider();
        temperatureField = new TextField();
        temperatureField.setPrefWidth(50);
        temperatureField.textProperty().bindBidirectional(temperatureSlider.valueProperty(), NumberFormat.getIntegerInstance());
        temperatureSlider.setValue(equipamento.getTemperature());

        HBox temperature = new HBox(temperatureSlider, temperatureField);
        temperature.setAlignment(Pos.CENTER);



        Label temperatureLabel = new Label("Indique a temperatura para o ar condicionado:");
        HBox label = new HBox(10,temperatureLabel);
        label.setAlignment(Pos.CENTER);
        label.setSpacing(10);
        label.setPadding(new Insets(10,10,10,10));
        label.setStyle("-fx-font-weight: bold;");

        //Botao OK
        Button buttonOk = new Button("Ok");
        buttonOk.setOnAction(e -> {
            ((ArCondicionado)equipamento).changeTemperature(temperatureSlider.getValue());
            temperatureLabel.getScene().setRoot(new MonitorMenu(equipamento.getCompartimento()));
        });

        //Botão Cancelar
        Button buttonCancel = new Button("Cancelar");
        buttonCancel.setOnAction(e -> temperatureLabel.getScene().setRoot(new MonitorMenu(equipamento.getCompartimento())));

        HBox buttons = new HBox(buttonOk, buttonCancel);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10));


        getChildren().addAll(label,temperature,buttons);
    }

    /**
     * Método seletor que devolve o valor do slider
     *
     * @return valor do slider
     */
    public double getValue() {
        return temperatureSlider.getValue();
        }

    /**
     * Método modificador que permite alterar a temperatura do slider
     *
     * @param temperature - valor a ser atribuido pelo slider
     */
    public void setValue(double temperature) {
        temperatureSlider.setValue(temperature);
        }
    }

