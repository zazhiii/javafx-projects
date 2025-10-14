package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

/**
 * @author lixh
 * @since 2025/10/13 22:42
 */

public class PenTool extends AbstractDrawingTool {
    private double startX, startY;

    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        // 设置线条拐角处和端点的样式为圆形，目的是让手绘线条更平滑
        baseGc.setLineJoin(StrokeLineJoin.ROUND);
        baseGc.setLineCap(StrokeLineCap.ROUND);
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        double endX = e.getX();
        double endY = e.getY();
        baseGc.strokeLine(startX, startY, endX, endY);
        startX = endX;
        startY = endY;
    }

    @Override
    public void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        // 重置线条样式为默认值
        baseGc.setLineJoin(null);
        baseGc.setLineCap(null);
        canvasStateManager.saveSnapshot();
    }
}

