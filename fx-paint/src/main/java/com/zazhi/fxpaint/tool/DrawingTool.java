package com.zazhi.fxpaint.tool;

import com.zazhi.fxpaint.core.CanvasStateManager;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Stack;

public interface DrawingTool {
    void onMousePressed(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    void onMouseDragged(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    void onMouseReleased(MouseEvent e, GraphicsContext baseGc, GraphicsContext previewGc);

    void setCanvasStateManager(CanvasStateManager canvasStateManager);
}
