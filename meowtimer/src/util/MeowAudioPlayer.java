package util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MeowAudioPlayer {
    private static final String SOUND_PATH = "assets/sound/meow.mp3";

    public static void playMeow() {
        try {
            Media media = new Media(new File(SOUND_PATH).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("無法播放喵叫聲：" + e.getMessage());
        }
    }
}