package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class CircleTool implements DrawingTool {
    private double startX, startY;

    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearPreview(previewGc);
        drawCircle(e, previewGc);
    }

    @Override
    public void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearPreview(previewGc);
        drawCircle(e, baseGc);
    }

    private void drawCircle(MouseEvent e, GraphicsContext gc){
        double radiusX = Math.abs(e.getX() - startX);
        double radiusY = Math.abs(e.getY() - startY);
        double topLeftX = Math.min(e.getX(), startX);
        double topLeftY = Math.min(e.getY(), startY);
        gc.strokeOval(topLeftX, topLeftY, radiusX, radiusY);
    }
}
