import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;


/**
 * Esta classe auxiliar permite a gestão da associação dos Equipamento aos respetivos Detetores através
 * da interface criada com o botão do mesmo
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class AssociateMenu extends VBox {
    /**
     * Construtor da classe AssociateMenu, recebe o compartimento onde o equipamento se encontra
     * e o equipamento ao qual o queremos associar.
     * Esta VBox vai conter 3 botões utéis, um que permitir "desconectar" um sensor a um dado atuador, o "associar"
     * onde permite associar o sensor a um atuador e o botão de "cancelar" para interromper a ação e voltar atrás.
     *
     * @param compartimento - Compartimento onde se encontra este Equipamento
     * @param equipamento - Equipamento que queremos associar
     */
    public AssociateMenu(final Compartimento compartimento,final Equipamento equipamento) {
        Label label = new Label(equipamento.toString());
        Label label1 = new Label("Escolha o sensor a associar:");

        label.setStyle("-fx-font-weight: bold;");

        final ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(compartimento.getAllEquipamentos().stream()
                                                                .filter(equipamento1 -> equipamento1.getTipo().equals(equipamento.getTipo()) && equipamento1 instanceof Sensor)
                                                                .toList());
        final ListView<Equipamento> list = new ListView<>(equipamentos);

        HBox buttonsGroup = new HBox(10);

        //Botao associar
        Button associateButton = new Button("Associar");
        associateButton.setOnAction(e->{
            Equipamento sensor = list.getSelectionModel().getSelectedItem();
            if(sensor instanceof DetetorDeFecho){
                ((DetetorDeFecho) sensor).setTrinco((TrincoEletrico) equipamento);
                ((TrincoEletrico)equipamento).setDetetorDeFecho((DetetorDeFecho)sensor);
            }else if(sensor instanceof DetetorDePosicao){
                ((DetetorDePosicao)sensor).setEstore((EstoreEletrico)equipamento);
                ((EstoreEletrico)equipamento).setDetetorDePosicao((DetetorDePosicao)sensor);
            }else{
                ((DetetorDeEnergia)sensor).setFogao((Fogao)equipamento);
                ((Fogao)equipamento).setDetetorDeEnergia((DetetorDeEnergia)sensor);
            }
            list.getScene().setRoot(new CompartimentoEdition(compartimento));
        });

        //Botao desconectar
        Button desconectButton = new Button("Desconectar");
        desconectButton.setOnAction( e->new Confirmation("Desconectar Sensor","Quer mesmo desconectar o sensor?"
                , e2->{
                    Equipamento sensor = list.getSelectionModel().getSelectedItem();
                        if(sensor instanceof DetetorDeFecho){
                            ((DetetorDeFecho) sensor).setTrinco(null);
                            ((TrincoEletrico)equipamento).setDetetorDeFecho(null);
                        }else{
                            ((DetetorDePosicao)sensor).setEstore(null);
                            ((EstoreEletrico)equipamento).setDetetorDePosicao(null);
                        }
                        label.getScene().setRoot(new CompartimentoEdition(compartimento));
        }));

        //Botão cancelar
        Button cancelButton = new Button("Cancelar");
        cancelButton.setOnAction(e-> list.getScene().setRoot(new CompartimentoEdition(compartimento)));

        buttonsGroup.getChildren().addAll(associateButton,desconectButton,cancelButton);
        getChildren().addAll(label,label1,list,buttonsGroup);
        setSpacing(10);
        setPadding(new Insets(10));
    }
}
