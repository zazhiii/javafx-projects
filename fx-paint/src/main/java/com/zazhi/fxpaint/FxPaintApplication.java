package com.zazhi.fxpaint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2025/10/13
 * @description: 绘图软件
 */
public class FxPaintApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/paint.fxml"));
        stage.setTitle("FxPaint");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
