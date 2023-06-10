
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaitentDashboard extends Stage {

    private Scene PaitentDashboard;

    public PaitentDashboard() throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("PatientFxml/PatientDasbord.fxml"));
        PaitentDashboard = new Scene(p);
        this.setScene(PaitentDashboard);
        this.setTitle("Paitent Dashboard");
    }

}

