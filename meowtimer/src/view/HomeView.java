package view;

import controller.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;

public class HomeView extends StackPane {
    public HomeView() {
        try {
            BackgroundImage bgImage = new BackgroundImage(
                    new Image(new FileInputStream("assets/image/cat_bg.jpg")),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(600, 400, false, false, false, false)
            );
            setBackground(new Background(bgImage));
        } catch (Exception e) {
            System.out.println("背景圖載入失敗：" + e.getMessage());
        }

        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);
        content.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-padding: 20px; -fx-background-radius: 15;");

        Text title = new Text("喵喵計時器");
        title.setFont(Font.font(30));

        Button startBtn = new Button("開始煮蛋 🍳");
        startBtn.setFont(Font.font(20));
        startBtn.setOnAction(e -> SceneController.getInstance().switchToEggOptionView());

        Button historyBtn = new Button("查看歷史紀錄 📝");
        historyBtn.setFont(Font.font(18));
        historyBtn.setOnAction(e -> SceneController.getInstance().switchToHistory());

        content.getChildren().addAll(title, startBtn, historyBtn);
        getChildren().add(content);
    }
}
