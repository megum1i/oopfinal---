package app;

import controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneController.getInstance().setPrimaryStage(primaryStage);
        SceneController.getInstance().switchToHome();
    }

    public static void main(String[] args) {
        launch(args);
    }
}