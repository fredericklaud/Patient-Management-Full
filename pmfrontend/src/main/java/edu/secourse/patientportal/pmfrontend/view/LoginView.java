package edu.secourse.patientportal.pmfrontend.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private final Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;
    }

    public Parent getView() {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        Label title = new Label("Patient Apointment System");
        return null;
    }
}
