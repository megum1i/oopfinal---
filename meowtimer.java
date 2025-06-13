package app;

import javafx.application.Application;
import javafx.stage.Stage;
import app.controller.SceneController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneController.init(primaryStage);
        SceneController.switchToHome();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
