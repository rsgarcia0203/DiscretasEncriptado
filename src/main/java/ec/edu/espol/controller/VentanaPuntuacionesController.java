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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaPuntuacionesController implements Initializable {

    @FXML
    private Label j1;
    @FXML
    private Label j2;
    @FXML
    private Label j3;
    @FXML
    private Label j4;
    @FXML
    private Label j5;
    @FXML
    private Label j6;
    @FXML
    private Label j7;
    @FXML
    private Label j8;
    @FXML
    private Label j9;
    @FXML
    private Label j10;
    @FXML
    private Label p1;
    @FXML
    private Label p2;
    @FXML
    private Label p3;
    @FXML
    private Label p4;
    @FXML
    private Label p5;
    @FXML
    private Label p6;
    @FXML
    private Label p7;
    @FXML
    private Label p8;
    @FXML
    private Label p9;
    @FXML
    private Label p10;
    @FXML
    private ImageView btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label[] arrP = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
        Label[] arrJ = {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
        
    }    

    @FXML
    private void mouseHover(MouseEvent event) {
        Sounds.hover();
    }

    @FXML
    private void toMain(MouseEvent event) {
        Sounds.click();

        try {
            App.setRoot("VentanaPrincipal");
        } catch (IOException ex) {

        }
    }
    
}
