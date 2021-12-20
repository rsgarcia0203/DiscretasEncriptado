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
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private Button btn_newGame;
    @FXML
    private Button btn_points;
    @FXML
    private Button btn_exit;
    @FXML
    private ImageView btn_audio;
    
    //private Sound bgsound = new Sound();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //if(bgsound != null){
        //    bgsound.playBGMusic();
        //}
    }

    @FXML
    private void btnPressed(MouseEvent event) {

        if (btn_newGame.isPressed()) {
            btn_newGame.setEffect(new InnerShadow());
            try {
                FXMLLoader fxmlloader = App.loadFXMLoader("VentanaJuego");
                App.setRoot(fxmlloader);
                Sound.goButton();
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana.");
                a.show();
            }
        } else if (btn_points.isPressed()) {
            btn_points.setEffect(new InnerShadow());
            try {
                FXMLLoader fxmlloader = App.loadFXMLoader("VentanaPuntuacion");
                App.setRoot(fxmlloader);
                Sound.click();
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana.");
                a.show();
            }
        } else if (btn_exit.isPressed()) {
            btn_exit.setEffect(new InnerShadow());
            Sound.click();
        }
        
    }

    @FXML
    private void btnReleased(MouseEvent event) {

        btn_newGame.setEffect(new DropShadow());
        btn_points.setEffect(new DropShadow());
        btn_exit.setEffect(new DropShadow());

    }

    @FXML
    private void audioChange(MouseEvent event) {
        
        //if(!bgsound.isPlaying()){
        //    btn_audio.setImage(new Image("ec\\edu\\espol\\img\\volume.png"));
        //    bgsound.muteBGMusic();
        //} else {
        //    btn_audio.setImage(new Image("ec\\edu\\espol\\img\\mute.png")); 
        //    bgsound.desmuteBGMusic();
        //}
        
    }

    @FXML
    private void exit(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
