package edu.secourse.patientportal.pmfrontend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PatientMgtController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
