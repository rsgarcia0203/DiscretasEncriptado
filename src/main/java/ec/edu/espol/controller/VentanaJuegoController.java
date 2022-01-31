/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.encriptadodiscretas.App;
import ec.edu.espol.model.Crypto;
import ec.edu.espol.model.Jugador;
import ec.edu.espol.model.PartidaCrypto;
import ec.edu.espol.model.Sound;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaJuegoController implements Initializable {

    @FXML
    private ImageView btn_back;
    @FXML
    private ImageView a1;
    @FXML
    private ImageView a2;
    @FXML
    private ImageView a3;
    @FXML
    private Label words;
    @FXML
    private Label points;
    @FXML
    private Button btn_send;
    @FXML
    private Label encryptWord;

    private String selectedWord;
    private GridPane gridpane;
    @FXML
    private Pane paneCentral;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        encryptWord.setText(PartidaCrypto.crypto.encrypt("hola"));
    }

    @FXML
    private void mousePressed(MouseEvent event) {
        btn_back.setOpacity(0.5);
    }

    @FXML
    private void mouseEntered(MouseEvent event) {
        btn_back.setOpacity(0.7);
    }

    @FXML
    private void back(MouseEvent event) {
        try {

            Sound.clickBack();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "¿Está seguro de regresar a la pantalla principal?, se perderán todos los datos de la partida actual.");
            a.setTitle("CRYPTOGAME");
            a.setHeaderText("Confirmación de salida");
            Optional<ButtonType> resultado = a.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                FXMLLoader fxmlloader = App.loadFXMLoader("VentanaPrincipal");
                App.setRoot(fxmlloader);
            }

        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana.");
            a.show();
        }
    }

    @FXML
    private void mouseReleased(MouseEvent event) {
        btn_back.setOpacity(0.5);
    }

    @FXML
    private void mouseExited(MouseEvent event) {
        btn_back.setOpacity(1);
    }

    @FXML
    private void sendReleased(MouseEvent event) {
        btn_send.setEffect(new DropShadow());
    }

    @FXML
    private void sendPressed(MouseEvent event) {
        btn_send.setEffect(new InnerShadow());
    }

    private void mistake() {

        Sound.mistake();
        PartidaCrypto.mistake();

        if (PartidaCrypto.intentos == 2) {
            a3.setVisible(false);
        } else if (PartidaCrypto.intentos == 1) {
            a2.setVisible(false);
        } else if (PartidaCrypto.intentos == 0) {
            a1.setVisible(false);

            try {
                FXMLLoader fxmlloader = App.loadFXMLoader("VentanaPrincipal");
                App.setRoot(fxmlloader);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana.");
                a.show();
            }

        }

    }

    private void success() {

        PartidaCrypto.acert();
        Sound.success();

    }

    private void compare() {

        if ((PartidaCrypto.crypto.encrypt(selectedWord)).equals(encryptWord.getText())) {
            success();
            points.setText(String.valueOf(PartidaCrypto.puntos));
            words.setText(String.valueOf(PartidaCrypto.palabrasAcertadas));

        } else {
            mistake();
            points.setText(String.valueOf(PartidaCrypto.puntos));
            words.setText(String.valueOf(PartidaCrypto.palabrasAcertadas));
        }

    }

    public void generarPalabras() {

        // Creo el GridPane que contendrá mis palabras desencriptadas
        this.gridpane = new GridPane();

        double width = 795 / 3;
        double height = 271 / 3;

        //Recorro mi sopa por fila y columna, uso for porque es esencial guardar las coordenadas (x,y) para el gridpana
        for (int y = 0; y < 3; y++) {

            // creación casillas con palabras
            for (int x = 0; x < 3; x++) {

                int i = (int) (Math.random() * PartidaCrypto.palabras.size());
                String palabra = PartidaCrypto.palabras.get(i); //Obtengo mi elemento por columna

                StackPane pane = crearCasilla(width, height, palabra);

                gridpane.add(pane, x, y); //Agrego al gridpane el contener en la posicion X,Y

            }
        }
        
        paneCentral.getChildren().add(gridpane);
    }

    private StackPane crearCasilla(double width, double height, String palabra) {

        StackPane pane = new StackPane();
        pane.setPrefSize(width, height);
        pane.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 0px;");
        pane.setCursor(Cursor.HAND);

        Label contPalabra = new Label(palabra); //Lo contengo en un label para mostrar
        contPalabra.setMouseTransparent(true);

        Pane fondo = new Pane();

        pane.getChildren().add(fondo);
        pane.getChildren().add(contPalabra);
        StackPane.setAlignment(contPalabra, Pos.CENTER);

        pane.setOnMouseClicked(t -> seleccionarPalabra(fondo, palabra));

        pane.setOnMouseEntered(e -> mouseEnteredPane(pane));
        pane.setOnMouseExited(e -> mouseExitedPane(pane));
        pane.setOnMousePressed(e -> mouseExitedPane(pane));
        pane.setOnMouseReleased(e -> mouseEnteredPane(pane));

        return pane;

    }

    private void mouseEnteredPane(StackPane p) {
        p.setStyle(p.getStyle() + " -fx-background-color:#5db6ff");
    }

    private void mouseExitedPane(StackPane p) {
        p.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 0px;");
    }

    public void seleccionarPalabra(Pane fondo, String palabra) {
        Sound.click();
        
        for (Node node: this.gridpane.getChildren()){
            node.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 0px;");
        }
        
        fondo.setStyle("-fx-background-color:#5db6ff");
        this.selectedWord = palabra;        

    }

    @FXML
    private void send(MouseEvent event) {
    }
}
