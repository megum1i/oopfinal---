package view;

import controller.SceneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HistoryView extends VBox {
    public HistoryView() {
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Text title = new Text("歷史紀錄");
        title.setFont(Font.font(24));

        ListView<String> list = new ListView<>();
        list.getItems().addAll(
                "煮蛋 - 3 分鐘",
                "蒸蛋 - 5 分鐘",
                "茶葉蛋 - 滷7+加熱10分鐘",
                "自訂 - 2 分鐘"
        );

        Button back = new Button("← 回首頁");
        back.setOnAction(e -> SceneController.getInstance().switchToHome());

        getChildren().addAll(title, list, back);
    }
}