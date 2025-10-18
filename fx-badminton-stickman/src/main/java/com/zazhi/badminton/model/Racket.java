package com.zazhi.badminton.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
// 球拍
public class Racket extends Rectangle {

    public Racket(double x, double y) {
        super(x, y, 15, 60); // 球拍宽度15，高度60
        setFill(Color.BROWN);
    }

    public void updatePosition(double stickmanX, double stickmanY) {
        // 球拍挂在火柴人右手（大概右上位置）
        setX(stickmanX + 30);
        setY(stickmanY - 20);
    }
}
