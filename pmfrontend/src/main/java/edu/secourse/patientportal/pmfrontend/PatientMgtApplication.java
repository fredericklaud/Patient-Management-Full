package edu.secourse.patientportal.pmfrontend;

import edu.secourse.patientportal.pmfrontend.view.LoginView;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientMgtApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Patient Appointment System");

        LoginView loginView = new LoginView(stage);
        stage.setScene(new Scene(loginView.getView(), 400, 300));

        stage.show();
    }
//        FXMLLoader fxmlLoader = new FXMLLoader(PatientMgtApplication.class.getResource("/view/login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Patient Portal Login");
//        stage.setScene(scene);
//        stage.show();
}
