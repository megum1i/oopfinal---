package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import util.MeowAudioPlayer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerSelectView extends VBox {

    private VBox timersBox = new VBox(10);

    public TimerSelectView(String eggType, int[] minutesOptions) {
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Label title = new Label(eggType + " - 選擇時間");
        title.setFont(Font.font(24));

        HBox btnBox = new HBox(10);
        btnBox.setAlignment(Pos.CENTER);

        for (int min : minutesOptions) {
            Button btn = new Button(min + " 分鐘");
            btn.setFont(Font.font(16));
            btn.setOnAction(e -> addNewTimer(min));
            btnBox.getChildren().add(btn);
        }

        timersBox.setAlignment(Pos.CENTER_LEFT);

        Button backBtn = new Button("← 回選單");
        backBtn.setOnAction(e -> controller.SceneController.getInstance().switchToEggOptionView());

        getChildren().addAll(title, btnBox, timersBox, backBtn);
    }

    private void addNewTimer(int minutes) {
    	HBox timerLine = new HBox(10);
    	timerLine.setAlignment(Pos.CENTER_LEFT);

    	Label label = new Label("剩下時間: " + minutes + ":00");
    	label.setFont(Font.font(18));

    	Button pauseBtn = new Button("暫停");
    	Button deleteBtn = new Button("刪除");

    	timerLine.getChildren().addAll(label, pauseBtn, deleteBtn);
    	timersBox.getChildren().add(timerLine);

    	Timer timer = new Timer();
    	int[] timeLeft = {minutes * 60};
    	boolean[] isPaused = {false};

    	pauseBtn.setOnAction(e -> {
    	    isPaused[0] = !isPaused[0];
    	    pauseBtn.setText(isPaused[0] ? "繼續" : "暫停");
    	});

    	deleteBtn.setOnAction(e -> {
    	    timer.cancel();
    	    timersBox.getChildren().remove(timerLine);
    	});

    	timer.scheduleAtFixedRate(new TimerTask() {
    	    @Override
    	    public void run() {
    	        if (isPaused[0]) return;

    	        if (timeLeft[0] <= 0) {
    	            timer.cancel();
    	            Platform.runLater(() -> {
    	                label.setText("✅ 時間到！");
    	                util.MeowAudioPlayer.playMeow();
    	            });
    	        } else {
    	            int min = timeLeft[0] / 60;
    	            int sec = timeLeft[0] % 60;
    	            Platform.runLater(() ->
    	                    label.setText(String.format("剩下時間: %02d:%02d", min, sec)));
    	            timeLeft[0]--;
    	        }
    	    }
    	}, 0, 1000);
    }
}