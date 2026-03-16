import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

/**
 * Esta classe permite Monitorizar um dado compartimento recebido por parâmetro
 *
 * @author Gonçalo Barracha, Rodrigo Cradoso
 * @version 28/06/2024
 */
public class MonitorMenu extends BorderPane {
    /**
     * Construtor da classe MonitorMenu, recebe um Compargtimento a ser visualizado.
     * Esta BorderPane contém todos os Equipamentos existentes no Compartimento selecionado e o seu estado atual,
     * Contém uma GridPane e em cada célula, uma imagem ilustrativa do equipamento, e também possui um botão "Voltar"
     * que permite regressar ao Menu Inicial.
     *
     * @param compartimento - Compartimento a ser Monitorado
     */
    public MonitorMenu(final Compartimento compartimento) {
        Label label = new Label(compartimento.getDesignacao()); // Nome Compartimento
        label.setStyle("-fx-font-weight: bold;");
        label.setFont(new Font("Arial", 30));
        HBox idCompartimento = new HBox(10, label);
        idCompartimento.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane(); // Grid Pane
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(50));
        grid.setAlignment(Pos.CENTER);

        int numColumns = 3; // Número de colunas desejado
        int cellSize = 75; // Tamanho fixo para largura e altura das células

        for (int i = 0; i < numColumns; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMinWidth(cellSize);
            colConst.setPrefWidth(cellSize);
            colConst.setMaxWidth(cellSize);
            grid.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < compartimento.getAllEquipamentos().size() / numColumns + 1; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setMinHeight(cellSize);
            rowConst.setPrefHeight(cellSize);
            rowConst.setMaxHeight(cellSize);
            grid.getRowConstraints().add(rowConst);
        }

        int row = 0;
        int colunm = 0;
        for (Equipamento equipamento : compartimento.getAllEquipamentos()) {
            if (colunm == numColumns) {
                colunm = 0;
                row++;
            }

            if (equipamento instanceof Termometro) { // Termometro
                Image termometroImage = new Image("images/termometro.png");
                ImageView termometroImageView = new ImageView(termometroImage);
                termometroImageView.setFitWidth(25);
                termometroImageView.setFitHeight(25);

                Label id = new Label("TM" + equipamento.getId());
                Label temperatura = new Label(((Termometro) equipamento).getTemperature() + "°C");
                VBox vbox = new VBox(5, id, termometroImageView, temperatura);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);

            } else if (equipamento instanceof ArCondicionado) { // Ar Condicionado
                Image acImage = new Image("images/ac.png");
                ImageView acImageView = new ImageView(acImage);
                acImageView.setFitWidth(25);
                acImageView.setFitHeight(25);

                Label id = new Label("AC" + equipamento.getId());
                Label temperatura = new Label(((ArCondicionado) equipamento).getTemperature() + "°C");
                temperatura.setOnMouseClicked(e ->
                        id.getScene().setRoot(new TemperatureViewer((ArCondicionado) equipamento)));
                acImageView.setOnMouseClicked(e -> {
                    ((ArCondicionado) equipamento).act();
                    id.getScene().setRoot(new MonitorMenu(compartimento));
                });
                VBox vbox = new VBox(5, id, acImageView, temperatura);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
                // Ar Condicionado e Termometro
            } else if (equipamento instanceof DetetorDeFecho) { // Detetor de Fecho
                Image detetorFechoImage;
                ImageView detetorFechoImageView;
                if (((DetetorDeFecho) equipamento).isOpen()) {
                    detetorFechoImage = new Image("images/detetor_fecho_aberto.png");
                    detetorFechoImageView = new ImageView(detetorFechoImage);
                } else {
                    detetorFechoImage = new Image("images/detetor_fecho_fechado.png");
                    detetorFechoImageView = new ImageView(detetorFechoImage);
                }
                detetorFechoImageView.setFitWidth(25);
                detetorFechoImageView.setFitHeight(25);

                Label id = new Label("DF" + equipamento.getId());
                Label status = new Label(((DetetorDeFecho) equipamento).isOpen() ? "Aberto" : "Fechado");

                VBox vbox = new VBox(5, id, detetorFechoImageView, status);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox

                grid.add(vbox, colunm++, row);

            } else if (equipamento instanceof DetetorDeAgua) { // Detetor de Agua
                Image detetorDeAguaImg;
                ImageView detetorAguaImgView;
                if (((DetetorDeAgua) equipamento).isWatterOpen()) {
                    detetorDeAguaImg = new Image("images/detetor_energia.png");
                    detetorAguaImgView = new ImageView(detetorDeAguaImg);
                } else {
                    detetorDeAguaImg = new Image("images/detetor_energia.png");
                    detetorAguaImgView = new ImageView(detetorDeAguaImg);
                }
                detetorAguaImgView.setFitWidth(25);
                detetorAguaImgView.setFitHeight(25);

                Label id = new Label("DA" + equipamento.getId());
                Label status = new Label(((DetetorDeAgua) equipamento).isWatterOpen() ? "Aberto" : "Fechado");

                VBox vbox = new VBox(5, id, detetorAguaImgView, status);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox

                grid.add(vbox, colunm++, row);
            } else if (equipamento instanceof DetetorDePosicao) {  // Detetor de Posicao
                Image detetorPosicaoImage;
                ImageView detetorPosicaoImageView;
                if (((DetetorDePosicao) equipamento).getPositionFromList().equals(ListaPosicoes.OPEN)) {
                    detetorPosicaoImage = new Image("images/detetor_posicao_open.png");
                    detetorPosicaoImageView = new ImageView(detetorPosicaoImage);
                } else if (((DetetorDePosicao) equipamento).getPositionFromList().equals(ListaPosicoes.TWO_THIRDS)) {
                    detetorPosicaoImage = new Image("images/detetor_posicao_two_thirds.png");
                    detetorPosicaoImageView = new ImageView(detetorPosicaoImage);
                } else if (((DetetorDePosicao) equipamento).getPositionFromList().equals(ListaPosicoes.HALF_OPEN)) {
                    detetorPosicaoImage = new Image("images/detetor_posicao_half.png");
                    detetorPosicaoImageView = new ImageView(detetorPosicaoImage);

                } else if (((DetetorDePosicao) equipamento).getPositionFromList().equals(ListaPosicoes.ONE_THIRD)) {
                    detetorPosicaoImage = new Image("images/detetor_posicao_one_third.png");
                    detetorPosicaoImageView = new ImageView(detetorPosicaoImage);
                } else {
                    detetorPosicaoImage = new Image("images/detetor_posicao_close.png");
                    detetorPosicaoImageView = new ImageView(detetorPosicaoImage);
                }
                HBox view = new HBox(detetorPosicaoImageView);
                view.setAlignment(Pos.CENTER); // Centralizar HBox

                detetorPosicaoImageView.setFitWidth(25);
                detetorPosicaoImageView.setFitHeight(25);

                Label id = new Label("DP" + equipamento.getId());
                Label status = new Label(((DetetorDePosicao) equipamento).getPositionFromList().name());
                VBox vbox = new VBox(5, id, view, status);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
            } else if (equipamento instanceof InterruptorDeLampada) { // Interruptor De Lampada
                Image interruptorImage;
                ImageView detetorInterruptorImageView;
                Label id = new Label("IL" + equipamento.getId());
                if (((InterruptorDeLampada) equipamento).isLightOn()) {
                    interruptorImage = new Image("images/interruptor_lampada_on.png");
                    detetorInterruptorImageView = new ImageView(interruptorImage);
                } else {
                    interruptorImage = new Image("images/interruptor_lampada_off.png");
                    detetorInterruptorImageView = new ImageView(interruptorImage);
                }
                detetorInterruptorImageView.setOnMouseClicked(e -> {
                    ((InterruptorDeLampada) equipamento).act();
                    for (Equipamento equipamento1 : compartimento.getAllEquipamentos()) {
                        if (equipamento1 instanceof DetetorDeLuz) {
                            ((DetetorDeLuz) equipamento1).read();
                        }
                    }
                    id.getScene().setRoot(new MonitorMenu(compartimento));
                });
                detetorInterruptorImageView.setFitWidth(25);
                detetorInterruptorImageView.setFitHeight(25);

                VBox vbox = new VBox(5, id, detetorInterruptorImageView);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
            }else if (equipamento instanceof Torneira) { // Torneira
                    Image torneiraImg;
                    ImageView detetorTorneiraImageView;
                    Label id = new Label("TR" + equipamento.getId());
                    if (((Torneira) equipamento).isWatterOpen()) {
                        torneiraImg = new Image("images/torneiraA.png.jpg");
                        detetorTorneiraImageView = new ImageView(torneiraImg);
                        detetorTorneiraImageView = new ImageView(torneiraImg);
                    } else {
                        torneiraImg = new Image("images/torneiraF.png.jpg");
                        detetorTorneiraImageView = new ImageView(torneiraImg);
                    }
                    detetorTorneiraImageView.setOnMouseClicked(e -> {
                        ((Torneira) equipamento).act();
                        for (Equipamento equipamento10 : compartimento.getAllEquipamentos()) {
                            if (equipamento10 instanceof DetetorDeAgua) {
                                ((DetetorDeAgua) equipamento10).read();
                            }
                        }
                        id.getScene().setRoot(new MonitorMenu(compartimento));
                    });
                    detetorTorneiraImageView.setFitWidth(25);
                    detetorTorneiraImageView.setFitHeight(25);

                    VBox vbox = new VBox(5, id, detetorTorneiraImageView);
                    vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                    grid.add(vbox, colunm++, row);
            } else if (equipamento instanceof TrincoEletrico) { // Trinco Elétrico
                Image trincoImage;
                ImageView trincoImageView;
                Label id;
                final DetetorDeFecho sensor = ((TrincoEletrico) equipamento).getDetetorDeFecho();

                if (sensor != null) { // Label Equipamento
                    id = new Label("TE" + equipamento.getId() + "-> DF" + sensor.getId());
                } else {
                    id = new Label("TE" + equipamento.getId());
                }

                if (((TrincoEletrico) equipamento).isOpen()) { // ImageView
                    trincoImage = new Image("images/trinco_on.png");
                    trincoImageView = new ImageView(trincoImage);
                } else {
                    trincoImage = new Image("images/trinco_off.png");
                    trincoImageView = new ImageView(trincoImage);
                }
                trincoImageView.setOnMouseClicked(e -> { // SetOnMouseClicked
                    ((TrincoEletrico) equipamento).act();
                    if (sensor != null) {
                        sensor.read();
                    }
                    id.getScene().setRoot(new MonitorMenu(compartimento));
                });

                trincoImageView.setFitWidth(25);
                trincoImageView.setFitHeight(25);

                VBox vbox = new VBox(5, id, trincoImageView);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
            } else if (equipamento instanceof DetetorDeEnergia) { // Detetor de Energia
                Image detetorEnergiaImage;
                ImageView detetorEnergiaImageView;
                if (((DetetorDeEnergia) equipamento).isEnergyOn()) {
                    detetorEnergiaImage = new Image("images/detetor_energia1.png");
                    detetorEnergiaImageView = new ImageView(detetorEnergiaImage);
                } else {
                    detetorEnergiaImage = new Image("images/detetor_energia1.png");
                    detetorEnergiaImageView = new ImageView(detetorEnergiaImage);
                }
                detetorEnergiaImageView.setFitWidth(25);
                detetorEnergiaImageView.setFitHeight(25);

                Label id = new Label("DE" + equipamento.getId());
                Label status = new Label(((DetetorDeEnergia) equipamento).isEnergyOn() ? "Ligado" : "Desligado");

                VBox vbox = new VBox(5, id, detetorEnergiaImageView, status);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox

                grid.add(vbox, colunm++, row);


        } else if (equipamento instanceof Fogao) { // Fogao
                Image fogaoImage;
                ImageView fogaoImageView;
                Label id;
                final DetetorDeEnergia energia = ((Fogao) equipamento).getDetetorDeEnergia();

                if (energia != null) { // Label Equipamento
                    id = new Label("FG" + equipamento.getId() + "-> DE" + energia.getId());
                } else {
                    id = new Label("FG" + equipamento.getId());
                }

                if (((Fogao) equipamento).isEnergyOn()) { // ImageView
                    fogaoImage = new Image("images/fogao_ligado.png");
                    fogaoImageView = new ImageView(fogaoImage);
                } else {
                    fogaoImage = new Image("images/fogao.png");
                    fogaoImageView = new ImageView(fogaoImage);
                }
                fogaoImageView.setOnMouseClicked(e -> { // SetOnMouseClicked
                    ((Fogao) equipamento).act();
                    if (energia != null) {
                        energia.read();
                    }
                    id.getScene().setRoot(new MonitorMenu(compartimento));
                });

                fogaoImageView.setFitWidth(25);
                fogaoImageView.setFitHeight(25);

                VBox vbox = new VBox(5, id, fogaoImageView);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
            } else if (equipamento instanceof EstoreEletrico) { // Estore Eletrico
                Image estoreImage;
                ImageView estoreImageView;
                Label id;

                Label estado = new Label(((EstoreEletrico) equipamento).getPositionFromList().toString()); // Estado
                HBox es = new HBox(10, estado);
                es.setAlignment(Pos.CENTER); // Centralizar HBox

                final DetetorDePosicao sensor = ((EstoreEletrico) equipamento).getDetetorDePosicao(); // Detetor De Posicao

                if (sensor != null) { // Label Equipamento
                    id = new Label("EE" + equipamento.getId() + "-> DP" + sensor.getId());
                } else {
                    id = new Label("EE" + equipamento.getId());
                }
                estoreImage = new Image("images/start.png");
                estoreImageView = new ImageView(estoreImage);
                HBox view = new HBox(estoreImageView);
                view.setAlignment(Pos.CENTER); // Centralizar HBox

                estado.setOnMouseClicked(e -> { // Start
                    id.getScene().setRoot(new PositionMenu((EstoreEletrico) equipamento));
                });
                estoreImageView.setOnMouseClicked(e -> {
                    for (Equipamento equipamento1 : compartimento.getAllEquipamentos()) {
                        if (equipamento1 instanceof DetetorDePosicao) {
                            ((DetetorDePosicao) equipamento1).read();
                        }
                    }
                    ((EstoreEletrico) equipamento).act();
                    id.getScene().setRoot(new MonitorMenu(compartimento));
                });

                estoreImageView.setFitWidth(25);
                estoreImageView.setFitHeight(25);
                VBox vbox = new VBox(5, id, es, view);
                vbox.setAlignment(Pos.CENTER); // Centralizar VBox
                grid.add(vbox, colunm++, row);
            }
        }
        // Botão Voltar
        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> label.getScene().setRoot(new CompartimentoViewer(compartimento.getConsola())));

        HBox buttons = new HBox(10, backButton); // HBox Butoes
        buttons.setAlignment(Pos.CENTER);

        VBox mainContainer = new VBox(grid, buttons);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setSpacing(-40);

        setTop(idCompartimento);
        setCenter(mainContainer);
    }
}


