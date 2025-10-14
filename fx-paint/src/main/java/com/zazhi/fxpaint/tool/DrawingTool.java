package com.zazhi.fxpaint.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface DrawingTool {
    void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);
    void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);
    void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);
    default void clearPreview(GraphicsContext previewGc) {
        previewGc.clearRect(0, 0, previewGc.getCanvas().getWidth(), previewGc.getCanvas().getHeight());
    }
}
