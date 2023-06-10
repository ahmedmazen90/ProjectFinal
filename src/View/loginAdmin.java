
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginAdmin extends Stage{
    public Scene loginAdmin;
    public loginAdmin() throws IOException{
      Parent Admin = FXMLLoader.load(getClass().getResource("RegisrterFxml/LoginAdmin.fxml"));
        loginAdmin = new Scene(Admin);
        this.setTitle("login Page");
        this.setScene(loginAdmin);
}
}