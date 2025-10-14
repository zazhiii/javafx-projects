package com.zazhi.fxpaint.tool;

import com.zazhi.fxpaint.core.CanvasStateManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * @author lixh
 * @since 2025/10/14 16:03
 */
public abstract class AbstractDrawingTool implements DrawingTool {
    protected CanvasStateManager canvasStateManager;

    public abstract void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    public abstract void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    public abstract void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    protected void clearCanvas(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    @Override
    public void setCanvasStateManager(CanvasStateManager canvasStateManager) {
        this.canvasStateManager = canvasStateManager;
    }
}
