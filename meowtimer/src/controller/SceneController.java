package controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.HomeView;

public class SceneController {
    private static SceneController instance = new SceneController();
    private Stage primaryStage;

    private SceneController() {}

    public static SceneController getInstance() {
        return instance;
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void switchToHome() {
        Pane root = new HomeView();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("timer");
        primaryStage.show();
    }

    public void switchToEggOptionView() {
        Pane root = new view.EggOptionView();
        primaryStage.setScene(new Scene(root, 600, 400));
    }    
    
    public void switchToBoiledEgg() {
        primaryStage.setScene(new Scene(new view.TimerSelectView("煮蛋", new int[]{3, 5, 7}), 600, 400));
        }

   public void switchToSteamedEgg() {
            primaryStage.setScene(new Scene(new view.TimerSelectView("蒸蛋", new int[]{5, 7}), 600, 400));
        }

        public void switchToTeaEgg() {
            primaryStage.setScene(new Scene(new view.TimerSelectView("茶葉蛋", new int[]{7, 10}), 600, 400));
        }

        public void switchToCustomEgg() {
            primaryStage.setScene(new Scene(new view.CustomTimerView(), 600, 400));
        }    
    
        public void switchToHistory() {
            primaryStage.setScene(new Scene(new view.HistoryView(), 600, 400));
        }        
}