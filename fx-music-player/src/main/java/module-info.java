module fx.music.player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports com.zazhi.fxmusic;
    opens com.zazhi.fxmusic to javafx.fxml;
    opens com.zazhi.fxmusic.controller to javafx.fxml;
}