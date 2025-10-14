package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * @author lixh
 * @since 2025/10/13 23:46
 */
public class LineTool extends AbstractDrawingTool {
    private double startX, startY;

    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        startX = e.getX();
        startY = e.getY();
        clearCanvas(previewGc);
    }

    @Override
    public void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearCanvas(previewGc);
        previewGc.strokeLine(startX, startY, e.getX(), e.getY());
    }

    @Override
    public void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        clearCanvas(previewGc);
        baseGc.strokeLine(startX, startY, e.getX(), e.getY());
        canvasStateManager.saveSnapshot();
    }
}
