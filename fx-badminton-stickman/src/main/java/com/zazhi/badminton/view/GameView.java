package com.zazhi.badminton.view;

import com.zazhi.badminton.controller.GameController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameView {
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(600, 450);
        Scene scene = new Scene(pane);

        new GameController(pane, scene);

        stage.setScene(scene);
        stage.setTitle("火柴人羽毛球 - Demo 3");
        stage.show();
    }
}
