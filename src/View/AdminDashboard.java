
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AdminDashboard extends Stage {

    private Scene UserManager;
    private Scene AddUser;
    private Scene AppointManager;
    private Scene BookedManager;

    public AdminDashboard() throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("AdminFxml/UserManager.fxml"));
        UserManager = new Scene(p1);

        Parent p2 = FXMLLoader.load(getClass().getResource("AdminFxml/AddUser.fxml"));
        AddUser = new Scene(p2);

        Parent p3 = FXMLLoader.load(getClass().getResource("AdminFxml/AppointManager.fxml"));
        AppointManager = new Scene(p3);
        
        Parent p4 = FXMLLoader.load(getClass().getResource("AdminFxml/Booked.fxml"));
        BookedManager = new Scene(p4);

        this.setScene(UserManager);
        this.setTitle("Admin Dashboard");
    }

    public void changeTOUserManager() {
        this.setScene(UserManager);
    }

    public void changeTOAddUser() {
        this.setScene(AddUser);
    }

    public void changeTOAppointManager() {
        this.setScene(AppointManager);
    }
    
       public void changeTOBookedManager() {
        this.setScene(BookedManager);
    }
}
