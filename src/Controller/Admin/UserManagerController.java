
package Controller.Admin;

import Model.Users;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserManagerController implements Initializable {

    @FXML
    private TableView<Users> TableViewUsers;
    @FXML
    private TableColumn<Users, Integer> IDCol;
    @FXML
    private TableColumn<Users, String> UserNameCol;
    @FXML
    private TableColumn<Users, String> FirstNameCol;
    @FXML
    private TableColumn<Users, String> lastNameCol;
    @FXML
    private TableColumn<Users, Integer> AgeCol;
    @FXML
    private TableColumn<Users, String> EmailCol;
    @FXML
    private TableColumn<Users, String> PhoneCol;
    @FXML
    private TableColumn<Users, String> GenderCol;
    @FXML
    private TableColumn<Users, String> RoleCol;
    @FXML
    private Button addnew;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private Button logout;
    @FXML
    private TextField searchPatientTF;
    @FXML
    private Button ShowallPatient;
    @FXML
    private Button BtnpageUser;
    @FXML
    private Button BtnPageAppointments;
    @FXML
    private Button BtnPageBooked;
    @FXML
    private Button BtnSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
        FirstNameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
        UserNameCol.setCellValueFactory(new PropertyValueFactory("username"));
        AgeCol.setCellValueFactory(new PropertyValueFactory("age"));
        PhoneCol.setCellValueFactory(new PropertyValueFactory("phone"));
        EmailCol.setCellValueFactory(new PropertyValueFactory("email"));
        GenderCol.setCellValueFactory(new PropertyValueFactory("gender"));
        RoleCol.setCellValueFactory(new PropertyValueFactory("role"));
    }

    @FXML
    private void AddNewPachent(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOAddUser();
    }

    @FXML
    private void btndelete(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (TableViewUsers.getSelectionModel().getSelectedItem() != null) {
            Users selectUser = TableViewUsers.getSelectionModel().getSelectedItem();
            selectUser.delete();
        }
    }

    @FXML
    private void btnUpdate(ActionEvent event) {

    }

    @FXML
    private void btnlogout(ActionEvent event) throws IOException {
        ViewManger.openLoginPage();
        ViewManger.closeAdminDashboard();
    }

    @FXML
    private void btnShowallPatient(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Users> usersList
                = FXCollections.observableArrayList(Users.getAllUsers());
        TableViewUsers.setItems(usersList);
    }

    @FXML
    private void showSearch(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Users> usersList
                = FXCollections.observableArrayList(Users.getByFirstName(searchPatientTF.getText()));
        TableViewUsers.setItems(usersList);
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

}
