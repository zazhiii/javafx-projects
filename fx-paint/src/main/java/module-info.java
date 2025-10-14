module com.zazhi.fxpaint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.zazhi.fxpaint to javafx.fxml;
    opens com.zazhi.fxpaint.controller to javafx.fxml;
    exports com.zazhi.fxpaint;
    exports com.zazhi.fxpaint.core;
    opens com.zazhi.fxpaint.core to javafx.fxml;
}