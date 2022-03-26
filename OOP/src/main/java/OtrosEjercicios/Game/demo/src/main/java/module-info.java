module testing.TreasureHunting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // opens testing.Example to javafx.fxml;
    opens testing.TreasureHunting to java.fxml;

    exports testing.TreasureHunting;
    // exports testing.Example;
}
