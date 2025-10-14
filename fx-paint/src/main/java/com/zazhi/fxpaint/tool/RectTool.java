package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class RectTool implements DrawingTool {
    private double startX, startY;

    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearPreview(previewGc);
        drawRect(e, previewGc);
    }

    @Override
    public void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearPreview(previewGc);
        drawRect(e, baseGc);
    }

    private void drawRect(MouseEvent e, GraphicsContext gc){
        double minX = Math.min(e.getX(), startX);
        double minY = Math.min(e.getY(), startY);
        double width = Math.abs(e.getX() - startX);
        double height = Math.abs(e.getY() - startY);
        gc.strokeRect(minX, minY, width, height);
    }
}
