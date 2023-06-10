
package Controller;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;



public class RegisterController implements Initializable {

    @FXML
    private TextField userTF;
    @FXML
    private PasswordField passTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField PhoneTF;
    @FXML
    private TextField ageTF;
    @FXML
    private Button signin;
    @FXML
    private TextField FirstNameTF;
    @FXML
    private TextField LastNameTF;
    @FXML
    private ToggleGroup genderGruop;
    @FXML
    private ToggleGroup roleGruop;
    @FXML
    private RadioButton genderTF;
    @FXML
    private RadioButton roleTF;
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
    private void btnSignin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
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
        ViewManger.openLoginPage();
        // 
    }

    @FXML
    private void CancelRigester(ActionEvent event) throws IOException {
        ViewManger.openLoginPage();
        ViewManger.closeRegisterPage();
    }

}
