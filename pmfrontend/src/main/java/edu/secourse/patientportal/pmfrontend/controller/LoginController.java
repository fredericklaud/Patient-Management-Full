package edu.secourse.patientportal.pmfrontend.controller;

import edu.secourse.patientportal.pmfrontend.config.ApiClient;
import edu.secourse.patientportal.pmfrontend.util.Navigator;
import edu.secourse.patientportal.pmfrontend.util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML private Label errorLabel;

    public void handleLogin() {
        try {
            String json = String.format(
                    "{\"username\":\"%s\",\"password\":\"%s\"}",
                    usernameField.getText(),
                    passwordField.getText()
            );

            String response = ApiClient.post("/auth/login", json, null);

            // parse JSON (use Jackson)
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response);

            String token = node.get("token").asText();
            String role = node.get("role").asText();

            SessionManager.setSession(token, role);

            navigateToDashboard(role);

        } catch (Exception e) {
            errorLabel.setText("Login failed");
        }
    }

    private void navigateToDashboard(String role) throws IOException {
        if (role.equals("ADMIN")) {
            AdminController adminController = new AdminController();
            Navigator.loadScene("admin.fxml", adminController);
        } else if (role.equals("DOCTOR")) {
            DoctorController doctorController = new DoctorController();
            Navigator.loadScene("doctor.fxml", doctorController);
        } else {
            PatientController patientController = new PatientController();
            Navigator.loadScene("patient.fxml", patientController);
        }
    }

}
