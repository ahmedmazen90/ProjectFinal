
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginPage extends Stage {

    private Scene loginPage;

    public LoginPage() throws IOException {

        Parent PloginPage = FXMLLoader.load(getClass().getResource("RegisrterFxml/LoginPage.fxml"));
        loginPage = new Scene(PloginPage);
        this.setTitle("login Page");
        this.setScene(loginPage);
    }


}
