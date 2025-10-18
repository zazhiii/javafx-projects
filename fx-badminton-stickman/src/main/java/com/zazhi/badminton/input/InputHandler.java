package com.zazhi.badminton.input;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.util.HashSet;
import java.util.Set;

/**
 * 键盘输入管理器：持续追踪按键状态
 */
public class InputHandler {

    private final Set<KeyCode> pressedKeys = new HashSet<>();

    public void attachToScene(Scene scene) {
        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));
    }

    public boolean isPressed(KeyCode key) {
        return pressedKeys.contains(key);
    }
}
