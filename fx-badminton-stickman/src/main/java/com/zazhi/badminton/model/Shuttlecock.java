package com.zazhi.badminton.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// 羽毛球类
public class Shuttlecock extends Circle {
    private double vx = 0;
    private double vy = 2;
    private final double gravity = 0.2;

    public Shuttlecock(double x, double y) {
        super(x, y, 6, Color.ORANGE);
    }

    public void update() {
        vy += gravity;
        setCenterX(getCenterX() + vx);
        setCenterY(getCenterY() + vy);
    }

    public void bounce() {
        vy = -Math.abs(vy) * 0.8; // 反弹且衰减
    }

    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }
}
