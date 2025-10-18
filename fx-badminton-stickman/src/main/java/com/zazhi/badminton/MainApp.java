package com.zazhi.badminton;

import com.zazhi.badminton.view.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        new GameView().start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
