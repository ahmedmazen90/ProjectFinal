/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Booked;
import Model.BookedAppointments;
import Model.globalUser;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookedController implements Initializable {

    @FXML
    private TableView<Booked> TableViewUsers;
    @FXML
    private TableColumn<Booked, Integer> IDCol;
    @FXML
    private TableColumn<Booked, Integer> U_IDCol;
    @FXML
    private TableColumn<Booked, Integer> A_IDCol;
    @FXML
    private TableColumn<Booked, String> FirstnameCol;
    @FXML
    private TableColumn<Booked, String> LastnameCol;
    @FXML
    private TableColumn<Booked, Date> DateCol;
    @FXML
    private TableColumn<Booked, String> DayCol;
    @FXML
    private TableColumn<Booked, String> TimeCol;
    @FXML
    private TableColumn<Booked, String> StatusCol;
    @FXML
    private Button BtnFinish;
    @FXML
    private Button logout;
    @FXML
    private Button ShowallAppoint;
    @FXML
    private Button BtnpageUser;
    @FXML
    private Button BtnPageAppointments;
    @FXML
    private Button BtnPageBooked;
    @FXML
    private TextArea commentTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
        U_IDCol.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        A_IDCol.setCellValueFactory(new PropertyValueFactory("user_id"));
        FirstnameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
        LastnameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
        DateCol.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        DayCol.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        TimeCol.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        StatusCol.setCellValueFactory(new PropertyValueFactory("status"));
    }

    @FXML
    private void FinishBooked(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (TableViewUsers.getSelectionModel().getSelectedItem() != null) {
            Booked selectUser = TableViewUsers.getSelectionModel().getSelectedItem();
            Integer id = selectUser.getId();
            Integer A_id = selectUser.getAppointment_id();
            String comment = commentTF.getText();
            Integer U_id = globalUser.userLogin.getId();
            
            BookedAppointments BA = new BookedAppointments();
            BA.setAppointment_id(A_id);
            BA.setUser_id(U_id);
            BA.setStatus("finished");
            BA.setDoctor_comment(comment);
            BA.setId(id);
            BA.update();
        }
    }

    @FXML
    private void btnlogout(ActionEvent event) throws IOException {
        ViewManger.openLoginPage();
        ViewManger.closeAdminDashboard();
    }

    @FXML
    private void btnShowallAppoint(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Booked> BookedList
                = FXCollections.observableArrayList(Booked.getAllBooked());
        TableViewUsers.setItems(BookedList);
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
