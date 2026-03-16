import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Esta classe permite inicializar o Sistema com todas as informações que queremos,
 * permite também a gerenciação mais rápida e eficiente do programa.
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 27/06/2024
 */
public class AppStart extends Application {
    @Override
    public void start(Stage primaryStage){
        final Consola consola = Consola.readConsola("teste.txt");
        Scene scene = new Scene(new CompartimentoViewer(consola),400,300);
        primaryStage.setTitle("Sistema Domótico");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> consola.writeConsola("teste.txt"));
        primaryStage.show();
    }

}