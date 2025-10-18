package com.zazhi.badminton.model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Stickman extends Group {
    private double x, y;
    private final Line body;
    private final Circle head;
    private final Line leftLeg, rightLeg, leftArm, rightArm;
    private final Racket racket;

    // 新增旋转变换
    private final Group rightArmGroup;
    private final Rotate rotate;

    public Stickman(double x, double y) {
        this.x = x;
        this.y = y;

        head = new Circle(x, y - 30, 10, Color.BLACK);
        body = new Line(x, y - 20, x, y + 20);
        leftLeg = new Line(x, y + 20, x - 10, y + 40);
        rightLeg = new Line(x, y + 20, x + 10, y + 40);
        leftArm = new Line(x, y - 10, x - 20, y + 10);

        // 右臂和球拍
        rightArm = new Line(x, y - 10, x + 20, y + 10);
        racket = new Racket(x + 30, y - 20);

        // 右臂和球拍组成一个旋转组
        rightArmGroup = new Group(rightArm, racket);
        rotate = new Rotate(0, x, y - 10); // 以右肩为旋转中心
        rightArmGroup.getTransforms().add(rotate);

        getChildren().addAll(head, body, leftLeg, rightLeg, leftArm, rightArmGroup);
    }

    public void move(double dx) {
        x += dx;
        head.setCenterX(x);
        body.setStartX(x);
        body.setEndX(x);
        leftLeg.setStartX(x);
        leftLeg.setEndX(x - 10);
        rightLeg.setStartX(x);
        rightLeg.setEndX(x + 10);
        leftArm.setStartX(x);
        leftArm.setEndX(x - 20);
        rightArmGroup.setLayoutX(dx + rightArmGroup.getLayoutX());

        // 更新旋转中心
        rotate.setPivotX(x);
        rotate.setPivotY(y - 10);
    }

    /** 挥拍动画 */
    public void swingRacket() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.millis(120), new KeyValue(rotate.angleProperty(), 80)),
                new KeyFrame(Duration.millis(250), new KeyValue(rotate.angleProperty(), 0))
        );
        timeline.play();
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public Racket getRacket() { return racket; }
}
