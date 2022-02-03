/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.GameMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ec.edu.espol.model.Partida;
import ec.edu.espol.proyectodiscretas.App;
import ec.edu.espol.util.Sounds;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author rsgar
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private Label columnsLabel;
    @FXML
    private Label rowsLabel;
    @FXML
    private Pane plusColumn;
    private int jugadores = 1;
    private boolean xtreme = false;
    @FXML
    private Label betLabel;
    @FXML
    private ImageView timer;
    @FXML
    private ImageView btnStart;
    @FXML
    private ImageView btn_points;
    @FXML
    private ImageView btnInfo;
    @FXML
    private ImageView btnExit;
    @FXML
    private ImageView gameMode;
    @FXML
    private ImageView btnSettings;
    @FXML
    private Pane opacityPanel;
    @FXML
    private VBox optionsPane;
    @FXML
    private ImageView btnClose;
    @FXML
    private VBox minusColum;

    private GameMode gm = GameMode.ONEPLAYER;

    @Override
    public void initialize(URL url, ResourceBundle rb) {    
    }

    @FXML
    private void minusRow(MouseEvent event) {
        Sounds.clickOne();
        int rows = Integer.parseInt(rowsLabel.getText());
        if (rows > 6) {
            rowsLabel.setText(String.valueOf(--rows));
        }
    }

    @FXML
    private void plusRow(MouseEvent event) {
        Sounds.clickOne();
        int rows = Integer.parseInt(rowsLabel.getText());
        if (rows < 20) {
            rowsLabel.setText(String.valueOf(++rows));
        }
    }

    @FXML
    private void minusColumn(MouseEvent event) {
        Sounds.clickOne();
        int columns = Integer.parseInt(columnsLabel.getText());
        if (columns > 6) {
            columnsLabel.setText(String.valueOf(--columns));
        }
    }

    @FXML
    private void plusColumn(MouseEvent event) {
        Sounds.clickOne();
        int columns = Integer.parseInt(columnsLabel.getText());
        if (columns < 20) {
            columnsLabel.setText(String.valueOf(++columns));
        }
    }

    @FXML
    private void minusBet(MouseEvent event) {
        Sounds.click();
        int apuesta = Integer.parseInt(betLabel.getText());
        if (apuesta > 0) {
            betLabel.setText(String.valueOf(apuesta - 10));
        }
        if (apuesta == 99) {
            betLabel.setText(String.valueOf(apuesta - 9));
        }
    }

    @FXML
    private void plusBet(MouseEvent event) {
        Sounds.click();
        jugadores = 1;

        int apuesta = Integer.parseInt(betLabel.getText());
        if (apuesta < 90) {
            betLabel.setText(String.valueOf(apuesta + 10));
        }
        if (apuesta == 90) {
            betLabel.setText(String.valueOf(apuesta + 9));
        }
    }

    @FXML
    private void startGame(MouseEvent event) {

        Sounds.goButton();

        int n_filas = Integer.parseInt(rowsLabel.getText());
        int n_columnas = Integer.parseInt(columnsLabel.getText());
        int apuesta = Integer.parseInt(betLabel.getText());

        if (jugadores == 1) {
            Partida.nuevaPartidaUnJugador(n_filas, n_columnas, apuesta, xtreme);
        } else {
            Partida.nuevaPartidaDosJugadores(n_filas, n_columnas, apuesta, xtreme);
        }

        try {
            App.setRoot("VentanaPreJuego");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void pointsWindow(MouseEvent event) {
        Sounds.click();

        try {
            App.setRoot("VentanaPuntuaciones");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void infoWindow(MouseEvent event) {
        Sounds.click();

        try {
            App.setRoot("VentanaInfo");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        Sounds.click();
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void showSettings(MouseEvent event) {
        Sounds.click();
        opacityPanel.setVisible(true);
        optionsPane.setVisible(true);
        appearAnimation2(opacityPanel);
        appearAnimation1(optionsPane);
        returnAnimation(optionsPane);
    }

    @FXML
    private void closeSettings(MouseEvent event) {
        Sounds.back();
        moveAnimation(optionsPane);
        disappearAnimation(opacityPanel);
        disappearAnimation(optionsPane);
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizarPantalla()));
        tl.setCycleCount(1);
        tl.setAutoReverse(false);
        tl.play();
    }

    @FXML
    private void changeGameMode(MouseEvent event) {
        Sounds.clickOne();

        if (gm == GameMode.ONEPLAYER) {
            gm = GameMode.TWOPLAYERS;
            jugadores = 2;
            betLabel.setText("0");
        } else if (gm == GameMode.TWOPLAYERS) {
            gm = GameMode.ONEPLAYER;
            jugadores = 1;
        }

        gameMode.setImage(new Image(gm.ruta));
    }

    @FXML
    private void mouseHover(MouseEvent event) {
        Sounds.hover();
    }

    private void moveAnimation(VBox vbox) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(600), vbox);
        tt.setToY(-300f);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);
        tt.play();
    }

    private void disappearAnimation(Pane pane) {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), pane);
        ft.setFromValue(pane.getOpacity());
        ft.setToValue(0);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void returnAnimation(VBox vbox) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(700), vbox);
        tt.setToY(277);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);
        tt.play();
    }

    private void appearAnimation1(Pane pane) {
        FadeTransition ft = new FadeTransition(Duration.millis(900), pane);
        ft.setFromValue(pane.getOpacity());
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void appearAnimation2(Pane pane) {
        FadeTransition ft = new FadeTransition(Duration.millis(900), pane);
        ft.setFromValue(pane.getOpacity());
        ft.setFromValue(0);
        ft.setToValue(0.55);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void actualizarPantalla() {
        opacityPanel.setVisible(false);
        optionsPane.setVisible(false);
    }

    @FXML
    private void timerReleased(MouseEvent event) {
        if (xtreme == true) {
            timer.setOpacity(1);
        } else {
            timer.setOpacity(0.50);
        }
    }

    @FXML
    private void timerExited(MouseEvent event) {
        if (xtreme == true) {
            timer.setOpacity(1);
        } else {
            timer.setOpacity(0.50);
        }
    }

    @FXML
    private void timerHover(MouseEvent event) {
        if (xtreme == true) {
            timer.setOpacity(0.80);
        } else {
            timer.setOpacity(0.70);
        }
    }

    @FXML
    private void clickTimer(MouseEvent event) {
        Sounds.clickOne();
        xtreme = !xtreme;
    }

    @FXML
    private void timerPressed(MouseEvent event) {
        if (xtreme == true) {
            timer.setOpacity(0.55);
            Sounds.click();
        } else {
            timer.setOpacity(0.40);
            Sounds.click();
        }
    }

}
