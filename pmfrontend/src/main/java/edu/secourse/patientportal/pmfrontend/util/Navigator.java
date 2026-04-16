package edu.secourse.patientportal.pmfrontend.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Navigator {
    public static void loadScene(String fxml, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                Navigator.class.getResource("/view/" + fxml)
        );
        loader.setController(controller);

        Parent root = loader.load();

        Stage stage = (Stage) Stage.getWindows()
                .filtered(Window::isShowing)
                .get(0);

        stage.setScene(new Scene(root));
        stage.show();
    }
}
