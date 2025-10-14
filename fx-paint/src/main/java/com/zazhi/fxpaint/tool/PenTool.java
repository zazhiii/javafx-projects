package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * @author lixh
 * @since 2025/10/13 22:42
 */

public class PenTool implements DrawingTool {
    private double startX, startY;

    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
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

    }
}

