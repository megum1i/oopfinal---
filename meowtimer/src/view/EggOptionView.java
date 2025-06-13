package view;

import controller.SceneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EggOptionView extends VBox {

    public EggOptionView() {
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Text title = new Text("選擇煮蛋類型 🍳");
        title.setFont(Font.font(24));

        Button btn1 = new Button("煮蛋");
        Button btn2 = new Button("蒸蛋");
        Button btn3 = new Button("茶葉蛋");
        Button btn4 = new Button("自訂義時間");

        Button backBtn = new Button("← 回首頁");

        btn1.setOnAction(e -> SceneController.getInstance().switchToBoiledEgg());
        btn2.setOnAction(e -> SceneController.getInstance().switchToSteamedEgg());
        btn3.setOnAction(e -> SceneController.getInstance().switchToTeaEgg());
        btn4.setOnAction(e -> SceneController.getInstance().switchToCustomEgg());

        backBtn.setOnAction(e -> SceneController.getInstance().switchToHome());

        for (Button btn : new Button[]{btn1, btn2, btn3, btn4, backBtn}) {
            btn.setFont(Font.font(18));
            btn.setMaxWidth(200);
        }

        getChildren().addAll(title, btn1, btn2, btn3, btn4, backBtn);
    }
}