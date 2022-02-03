package ec.edu.espol.util;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public abstract class Sounds {

    public static void playBGMusic() {

        String path = "src\\main\\resources\\ec\\edu\\espol\\sounds\\bg_music.mp3";
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.setVolume(0.30);

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

        mediaPlayer.play();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(160),
                        new KeyValue(mediaPlayer.volumeProperty(), 0.20),
                        new KeyValue(mediaPlayer.autoPlayProperty(), true),
                        new KeyValue(mediaPlayer.cycleCountProperty(), 10)
                ));
        timeline.play();
    }

    public static void goButton() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\go_button.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.4);
        mediaPlayer.play();
    }
    
    public static void clickOne(){
        
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\click_01.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.15);
        mediaPlayer.play();
    }
    
    
    public static void success(){
        
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\success.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
    
    public static void mistake(){
        
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\mistake.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
    
    public static void lose() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\lose.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
    
    public static void click() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\click.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.15);
        mediaPlayer.play();
    }
    
    public static void hover(){       
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\hover.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.15);
        mediaPlayer.play();

    }
    
    public static void back() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\click_back.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.6);
        mediaPlayer.play();
    }   
    
    public static void animation() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\animation.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(3),
                        new KeyValue(mediaPlayer.volumeProperty(), 0.20),
                        new KeyValue(mediaPlayer.autoPlayProperty(), true),
                        new KeyValue(mediaPlayer.cycleCountProperty(), 10)
                ));
        timeline.play();
    }
    
    public static void error() {
        Media sound = new Media(new File("src\\main\\resources\\ec\\edu\\espol\\sounds\\error.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
}
