/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyectodiscretas.App;
import ec.edu.espol.security.CesarEncrypt;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaPreJuegoController implements Initializable {

    @FXML
    private Label e7;
    @FXML
    private Label e8;
    @FXML
    private Label e9;
    @FXML
    private Label e1;
    @FXML
    private Label e2;
    @FXML
    private Label e3;
    @FXML
    private Label e4;
    @FXML
    private Label e6;
    @FXML
    private Label e5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        e1.setText(CesarEncrypt.decodeChars.get('A').toString());
        e2.setText(CesarEncrypt.decodeChars.get('B').toString());
        e3.setText(CesarEncrypt.decodeChars.get('C').toString());
        e4.setText(CesarEncrypt.decodeChars.get('D').toString());
        e5.setText(CesarEncrypt.decodeChars.get('E').toString());
        e6.setText(CesarEncrypt.decodeChars.get('F').toString());
        e7.setText(CesarEncrypt.decodeChars.get('X').toString());
        e8.setText(CesarEncrypt.decodeChars.get('Y').toString());
        e9.setText(CesarEncrypt.decodeChars.get('Z').toString());        
    }    

    @FXML
    private void checked(MouseEvent event) {   
        try {
            App.setRoot("VentanaJuego");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
