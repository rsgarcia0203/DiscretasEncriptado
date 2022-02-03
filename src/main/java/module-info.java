module ec.edu.espol.proyectodiscretas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;

    opens ec.edu.espol.proyectodiscretas to javafx.fxml;
    opens ec.edu.espol.controller to javafx.fxml;
    opens ec.edu.espol.model to javafx.fxml;
    opens ec.edu.espol.util to javafx.fxml;
    exports ec.edu.espol.proyectodiscretas;
    exports ec.edu.espol.controller;
    exports ec.edu.espol.model;
    exports ec.edu.espol.util;
      
}
