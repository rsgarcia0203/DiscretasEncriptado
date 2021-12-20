package ec.edu.espol.encriptadodiscretas;

import ec.edu.espol.model.Sound;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaPrincipal"), 1280, 800);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("CRYPTOGAME");
        stage.setResizable(false);
        stage.getIcons().add(new Image("ec/edu/espol/img/icon.png"));
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
     
    public static void setRoot(FXMLLoader fxmlloader) throws IOException {
        scene.setRoot(fxmlloader.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader loadFXMLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
    }


}