/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Users;
import Model.globalUser;
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
import javafx.scene.control.TextField;



public class LoginPageController implements Initializable {

    @FXML
    private TextField userTF;
    @FXML
    private PasswordField passTF;
    @FXML
    private Button login;
    @FXML
    private Button register;
    @FXML
    private Button loginadmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void btnRegister(ActionEvent event) throws IOException {
        ViewManger.openRegisterPage();
        ViewManger.closeLoginPage();
    }

    @FXML
    private void btnLog(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Users user = Users.LoginPatient(userTF.getText(), passTF.getText());
        if (user.getUsername() != null || user.getPassword() != null) {
            globalUser.userLogin = user;
            ViewManger.openPaitentDashboard();
            ViewManger.closeLoginPage();
        } else {
            System.out.println("UserName Or Password Invalid");
        }

    }

    @FXML
    private void btnAdminLogin(ActionEvent event) throws IOException {
        ViewManger.openloginAdmin();
        ViewManger.closeLoginPage();
    }

}
