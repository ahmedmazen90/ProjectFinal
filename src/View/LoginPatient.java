
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginPatient extends Stage{
        private Scene LoginPage;

    public LoginPatient() throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("RegisrterFxml/LoginPage.fxml"));
        LoginPage = new Scene(p);
        this.setScene(LoginPage);
        this.setTitle("Paitent Dashboard");
    }

}
