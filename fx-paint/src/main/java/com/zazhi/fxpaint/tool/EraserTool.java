package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class EraserTool extends AbstractDrawingTool {
    @Override
    public void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        baseGc.clearRect(e.getX(), e.getY(), baseGc.getLineWidth(), baseGc.getLineWidth());
    }

    @Override
    public void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc) {
        baseGc.clearRect(e.getX(), e.getY(), baseGc.getLineWidth(), baseGc.getLineWidth());
    }

    @Override
    public void onMouseReleased(MouseEvent e, GraphicsContext gc, GraphicsContext previewGc) {
        canvasStateManager.saveSnapshot();
    }
}
