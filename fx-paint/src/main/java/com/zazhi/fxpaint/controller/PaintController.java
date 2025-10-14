package com.zazhi.fxpaint.controller;

import com.zazhi.fxpaint.core.CanvasStateManager;
import com.zazhi.fxpaint.tool.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class PaintController {
    @FXML
    private Canvas baseCanvas;
    @FXML
    private Canvas previewCanvas;
    @FXML
    private ToggleButton lineBtn;
    @FXML
    private ToggleButton penBtn;
    @FXML
    private ToggleButton rectBtn;
    @FXML
    private ToggleButton circleBtn;
    @FXML
    private ToggleButton eraserBtn;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider widthSlider;

    private DrawingTool currentTool;
    private GraphicsContext baseGc;
    private GraphicsContext previewGc;
    private CanvasStateManager canvasStateManager;

    @FXML
    public void initialize() {
        baseGc = baseCanvas.getGraphicsContext2D();
        previewGc = previewCanvas.getGraphicsContext2D();
        canvasStateManager = new CanvasStateManager(baseCanvas);

        ToggleGroup group = new ToggleGroup();
        penBtn.setToggleGroup(group);
        lineBtn.setToggleGroup(group);
        rectBtn.setToggleGroup(group);
        circleBtn.setToggleGroup(group);
        eraserBtn.setToggleGroup(group);

        currentTool = new PenTool();
        penBtn.setSelected(true);

        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == penBtn) {
                currentTool = new PenTool();
            } else if (newToggle == lineBtn) {
                currentTool = new LineTool();
            } else if (newToggle == rectBtn) {
                currentTool = new RectTool();
            } else if (newToggle == circleBtn) {
                currentTool = new CircleTool();
            } else if (newToggle == eraserBtn) {
                currentTool = new EraserTool();
            }
            currentTool.setCanvasStateManager(canvasStateManager);
        });

        currentTool.setCanvasStateManager(canvasStateManager);


        previewCanvas.setOnMousePressed(e -> {
            setStyle(baseGc);
            setStyle(previewGc);
            currentTool.onMousePressed(e, baseGc, previewGc);
        });
        previewCanvas.setOnMouseDragged(e -> currentTool.onMouseDragged(e, baseGc, previewGc));
        previewCanvas.setOnMouseReleased(e -> currentTool.onMouseReleased(e, baseGc, previewGc));
    }

    @FXML
    void saveCanvasAsImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存图片");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG 图片", "*.png")
        );
        File file = fileChooser.showSaveDialog(baseCanvas.getScene().getWindow());
        if (file != null) {
            try {
                WritableImage image = baseCanvas.snapshot(null, null);
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException ex) {
                showError("保存失败: " + ex.getMessage());
            }
        }
    }

    private void setStyle(GraphicsContext gc) {
        gc.setStroke(colorPicker.getValue());
        gc.setLineWidth(widthSlider.getValue());
    }

    @FXML
    private void onClear() {
        canvasStateManager.clear();
    }

    @FXML
    void redo(ActionEvent event) {
        canvasStateManager.redo();
    }


    @FXML
    void undo(ActionEvent event) {
        canvasStateManager.undo();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
