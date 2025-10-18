package com.zazhi.badminton.controller;

import com.zazhi.badminton.model.Shuttlecock;
import com.zazhi.badminton.model.Stickman;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class GameController {
    private final Stickman stickman;
    private final Shuttlecock shuttlecock;

    public GameController(Pane gamePane, Scene scene) {
        stickman = new Stickman(200, 300);
        shuttlecock = new Shuttlecock(200, 100);

        gamePane.getChildren().addAll(stickman, shuttlecock);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) stickman.move(-10);
            if (e.getCode() == KeyCode.D) stickman.move(10);
            if (e.getCode() == KeyCode.SPACE) stickman.swingRacket();
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                shuttlecock.update();

                if (shuttlecock.getCenterY() >= 400) {
                    shuttlecock.setCenterY(400);
                    shuttlecock.bounce();
                }

                Shape intersect = Shape.intersect(shuttlecock, stickman.getRacket());
                if (intersect.getBoundsInLocal().getWidth() > 0) {
                    shuttlecock.bounce();
                }
            }
        }.start();
    }
}
