module org.example.cv10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.cv10 to javafx.fxml;
    exports org.example.cv10;
}