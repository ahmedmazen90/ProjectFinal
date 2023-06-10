
package Controller.Admin;

import Model.Users;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddUserController implements Initializable {

    @FXML
    private Button addnew;
    @FXML
    private Button logout;
    @FXML
    private Button BtnpageUser;
    @FXML
    private Button BtnPageAppointments;
    @FXML
    private Button BtnPageBooked;
    @FXML
    private ToggleGroup genderGruop;
    @FXML
    private ToggleGroup roleGruop;
    @FXML
    private TextField userTF;
    @FXML
    private TextField passTF;
    @FXML
    private TextField FirstNameTF;
    @FXML
    private TextField LastNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField PhoneTF;
    @FXML
    private TextField ageTF;
    @FXML
    private Button BtnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddNewPatient(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String firstname = FirstNameTF.getText();
        String lastname = LastNameTF.getText();
        String username = userTF.getText();
        int age = Integer.parseInt(ageTF.getText());
        String phone = PhoneTF.getText();
        String email = emailTF.getText();
        String password = passTF.getText();
        String gender = ((RadioButton) genderGruop.getSelectedToggle()).getText();
        String role = ((RadioButton) roleGruop.getSelectedToggle()).getText();

        Users user = new Users( username, password, firstname, lastname, age, email, phone, gender, role);
        user.Add();
        ViewManger.AdminDashboard.changeTOUserManager();
    }

    @FXML
    private void btnlogout(ActionEvent event) {
    }

    @FXML
    private void showPageUsers(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOUserManager();

    }

    @FXML
    private void showPageAppointments(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOAppointManager();

    }

    @FXML
    private void ShowPageBooked(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOBookedManager();
    }

    @FXML
    private void CancelAdd(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOUserManager();
    }

}
