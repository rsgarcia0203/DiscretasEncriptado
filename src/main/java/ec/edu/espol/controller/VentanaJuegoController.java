/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.encriptadodiscretas.App;
import ec.edu.espol.model.Crypto;
import ec.edu.espol.model.Jugador;
import ec.edu.espol.model.Partida;
import ec.edu.espol.model.Sound;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    @FXML
    private Label w1;
    @FXML
    private Label w2;
    @FXML
    private Label w3;
    @FXML
    private Label w4;
    @FXML
    private Label w5;
    @FXML
    private Label w6;
    @FXML
    private Label w7;
    @FXML
    private Label w8;
    @FXML
    private Label w9;

    private String selectedWord;
    private Jugador player;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;
    @FXML
    private Pane pane9;
    @FXML
    private Pane pane5;
    Crypto crypto = new Crypto();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Partida.nuevaPartida();
        encryptWord.setText(crypto.encrypt("hola"));
        player = new Jugador();
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
    private void send(MouseEvent event) {
        compare();

        paneDiselect(pane1);
        paneDiselect(pane2);
        paneDiselect(pane3);
        paneDiselect(pane4);
        paneDiselect(pane5);
        paneDiselect(pane6);
        paneDiselect(pane7);
        paneDiselect(pane8);
        paneDiselect(pane9);

    }

    @FXML
    private void sendPressed(MouseEvent event) {
        btn_send.setEffect(new InnerShadow());
    }

    private void mistake() {

        player.mistake();
        Sound.mistake();

        if (player.getIntentos() == 2) {
            a3.setVisible(false);
        } else if (player.getIntentos() == 1) {
            a2.setVisible(false);
        } else if (player.getIntentos() == 0) {
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

        player.acert();
        Sound.success();

    }

    private void paneSelected(Pane pane) {
        pane.setStyle(pane.getStyle() + "-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 1px; -fx-background-color:#5db6ff");
    }

    private void paneDiselect(Pane pane) {
        pane.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 1px; -fx-background-color:transparent");
    }

    private void compare() {

        if ((crypto.encrypt(selectedWord)).equals(encryptWord.getText())) {
            success();
            points.setText(String.valueOf(player.getPoints()));
            words.setText(String.valueOf(player.getPalabrasEncontradas()));

        } else {
            mistake();
            points.setText(String.valueOf(player.getPoints()));
            words.setText(String.valueOf(player.getPalabrasEncontradas()));
        }

    }

    @FXML
    private void paneSelect(MouseEvent event) {
        
        if (pane1.isPressed()) {
            selectedWord = w1.getText();
            paneSelected(pane1);
        } else if (pane2.isPressed()) {
            selectedWord = w2.getText();
            paneSelected(pane2);
        } else if (pane3.isPressed()) {
            selectedWord = w3.getText();
            paneSelected(pane3);
        } else if (pane4.isPressed()) {
            selectedWord = w4.getText();
            paneSelected(pane4);
        } else if (pane5.isPressed()) {
            selectedWord = w5.getText();
            paneSelected(pane5);
        } else if (pane6.isPressed()) {
            selectedWord = w6.getText();
            paneSelected(pane6);
        } else if (pane7.isPressed()) {
            selectedWord = w7.getText();
            paneSelected(pane7);
        } else if (pane8.isPressed()) {
            selectedWord = w8.getText();
            paneSelected(pane8);
        } else if (pane9.isPressed()) {
            selectedWord = w9.getText();
            paneSelected(pane9);
        }
    }
}
