/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyectodiscretas.App;
import ec.edu.espol.util.Sounds;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaInfoController implements Initializable {


    @FXML
    private ImageView btnBack;
    @FXML
    private ScrollPane scrollPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        scrollPane.setOpaqueInsets(Insets.EMPTY);
    }    
    
    @FXML
    private void toMain(MouseEvent event) {
        Sounds.click();

        try {
            App.setRoot("VentanaPrincipal");
        } catch (IOException ex) {

        }
    }

    @FXML
    private void mouseHover(MouseEvent event) {
        Sounds.hover();
    }


}
