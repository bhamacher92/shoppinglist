module weshopfaster {
    requires javafx.controls;
    requires javafx.fxml;

    opens lui to javafx.fxml;
    exports lui;
}