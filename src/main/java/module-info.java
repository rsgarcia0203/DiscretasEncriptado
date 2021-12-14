module ec.edu.espol.encriptadodiscretas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.encriptadodiscretas to javafx.fxml;
    exports ec.edu.espol.encriptadodiscretas;
}
