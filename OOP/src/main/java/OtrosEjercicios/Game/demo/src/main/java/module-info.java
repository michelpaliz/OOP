module testing {
    requires javafx.controls;
    requires javafx.fxml;

    opens testing to javafx.fxml;
    exports testing;
}
