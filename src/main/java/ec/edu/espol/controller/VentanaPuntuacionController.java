/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.encriptadodiscretas.App;
import ec.edu.espol.model.Sound;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaPuntuacionController implements Initializable {

    @FXML
    private ImageView btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            FXMLLoader fxmlloader = App.loadFXMLoader("VentanaPrincipal");
            App.setRoot(fxmlloader);
            Sound.clickBack();
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
    
}