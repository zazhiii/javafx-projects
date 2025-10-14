package com.zazhi.fxpaint.core;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.Stack;

public class CanvasStateManager {
    private final Canvas baseCanvas;
    private final GraphicsContext gc;
    private final Stack<Image> undoStack = new Stack<>();
    private final Stack<Image> redoStack = new Stack<>();

    public CanvasStateManager(Canvas canvas) {
        this.baseCanvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        saveSnapshot();
    }

    public void saveSnapshot() {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage snapshot = baseCanvas.snapshot(params, null);
        undoStack.push(snapshot);
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.size() <= 1) return;
        redoStack.push(undoStack.pop());
        Image prev = undoStack.peek();
        gc.clearRect(0, 0, baseCanvas.getWidth(), baseCanvas.getHeight());
        gc.drawImage(prev, 0, 0);
    }

    public void redo() {
        if (redoStack.isEmpty()) return;
        Image img = redoStack.pop();
        undoStack.push(img);
        gc.clearRect(0, 0, baseCanvas.getWidth(), baseCanvas.getHeight());
        gc.drawImage(img, 0, 0);
    }

    public void clear() {
        gc.clearRect(0, 0, baseCanvas.getWidth(), baseCanvas.getHeight());
        saveSnapshot();
    }
}
