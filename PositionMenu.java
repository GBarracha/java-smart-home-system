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
 * Esta classe permite selecionar a posição pretendida para o Estore Eletrico.
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class PositionMenu extends VBox {
    /**
     * Construtor da classe PositionMenu, esta VBox contém uma ObservableList de diferentes posições
     * que podem ser escolhidas, possui tambem 2 botões uteis, o "OK" que permite realizar a ação e o
     * "Cancelar" que interrompe a seleção e volta para trás.
     *
     * @param equipamento - Estore Elétrico a ser atualizado
     */
    public PositionMenu(final EstoreEletrico equipamento) {
        Label label = new Label("Indique a posição para o Estore:");
        label.setStyle("-fx-font-weight: bold;");
        label.setPadding(new Insets(10));

        final ObservableList<String> posicoes = FXCollections.observableArrayList("Fechado","Um terço","Meio Aberto","Dois terços","Aberto");
        final ListView<String> list = new ListView<>(posicoes);

        //Botao OK
        Button buttonOk = new Button("OK");
        buttonOk.setOnAction(e->{
            String selectedPosition = list.getSelectionModel().getSelectedItem();
            if(selectedPosition != null){
            switch (selectedPosition) {
                case "Fechado":
                    equipamento.setPosition(5);
                    equipamento.setPositionFromList(ListaPosicoes.CLOSE);
                    break;
                case "Um terço":
                    equipamento.setPosition(4);
                    equipamento.setPositionFromList(ListaPosicoes.ONE_THIRD);
                    break;
                case "Meio Aberto":
                    equipamento.setPosition(3);
                    equipamento.setPositionFromList(ListaPosicoes.HALF_OPEN);
                    break;
                case "Dois terços":
                    equipamento.setPosition(2);
                    equipamento.setPositionFromList(ListaPosicoes.TWO_THIRDS);
                    break;
                case "Aberto":
                    equipamento.setPosition(1);
                    equipamento.setPositionFromList(ListaPosicoes.OPEN);
                    break;
                }
            }
            list.getScene().setRoot(new MonitorMenu(equipamento.getCompartimento()));
        });
        //Botão cancelar
        Button cancel = new Button("Cancelar");
        cancel.setOnAction(e->list.getScene().setRoot(new MonitorMenu(equipamento.getCompartimento())));
        //Butoes Hbox
        HBox buttons = new HBox(buttonOk,cancel);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        getChildren().addAll(label,list,buttons);
        setSpacing(10);
        setPadding(new Insets(10));
    }
}
