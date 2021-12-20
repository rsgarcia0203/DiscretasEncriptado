/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author rsgar
 */
public class Sound {

    private Media sound;
    private MediaPlayer mediaPlayer;
    private String path;

    public Sound(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.sound = null;
        this.path = null;
    }

    public Sound() {

    }

    public void playBGMusic() {

        path = "src/main/resources/ec/edu/espol/sounds/bg_music.mp3";
        sound = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.setVolume(0.30);

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

        mediaPlayer.play();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(60),
                        new KeyValue(mediaPlayer.volumeProperty(), 0.20),
                        new KeyValue(mediaPlayer.autoPlayProperty(), true),
                        new KeyValue(mediaPlayer.cycleCountProperty(), 10)
                ));
        timeline.play();
    }

    public boolean isPlayingBG() {
        return !this.mediaPlayer.isMute();
    }

    public boolean isPlaying() {
        return this.mediaPlayer.getVolume() > 0.0;
    }

    public void muteBGMusic() {
        this.mediaPlayer.setVolume(0.0);
    }

    public void desmuteBGMusic() {
        this.mediaPlayer.setVolume(0.20);
    }

    public static void goButton() {

        Media sound = new Media(new File("src/main/resources/ec/edu/espol/sounds/go_button.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.4);
        mediaPlayer.play();
    }

    public static void click() {

        Media sound = new Media(new File("src/main/resources/ec/edu/espol/sounds/click.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.15);
        mediaPlayer.play();
    }

    public static void clickBack() {

        Media sound = new Media(new File("src/main/resources/ec/edu/espol/sounds/click_back.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.6);
        mediaPlayer.play();
    }

    public static void success() {

        Media sound = new Media(new File("src/main/resources/ec/edu/espol/sounds/success.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }

    public static void mistake() {

        Media sound = new Media(new File("src/main/resources/ec/edu/espol/sounds/mistake.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }

}
